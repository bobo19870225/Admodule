package cn.gz3create.module_ad.vip;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorProxyAd implements InvocationHandler {
    //真实对象
    private Object target;
    //拦截器的全限定名
    private String interceptorClass;

    //构造方法
    public InterceptorProxyAd(Object target, String interceptorClass) {
        super();
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * @param target 真实对象，要被代理的
     *               interceptorClass 拦截器的全限定名，用于生成拦截器对象
     * @return 代理对象
     */
    public static Object bind(Object target) {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InterceptorProxyAd(target, "cn.gz3create.module_ad.vip.AdInterceptor"));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //如果拦截器全限定名为空，那么执行原有对象的方法
        if (interceptorClass == null) {
            return method.invoke(target, args);
        }
        Object result = null;
        //通过反射生成拦截器对象
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();

        //调用前置方法
        if (interceptor.before(proxy, target, method, args)) {
            //如果before()方法返回真，那么执行原有对象的方法,不拦截
            result = method.invoke(target, args);
        } else {
            //如果before()方法返回false，那么执行around方法，原方法被拦截
            interceptor.around(proxy, target, method, args);
        }

        //最后调用after方法。
        interceptor.after(proxy, target, method, args);
        return result;
    }

}