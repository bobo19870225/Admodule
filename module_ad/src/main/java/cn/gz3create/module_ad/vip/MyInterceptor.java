package cn.gz3create.module_ad.vip;

import java.lang.reflect.Method;

import cn.gz3create.scyh_account.ScyhAccountLib;

/**
 * 模拟登录拦截，若登录，执行该方法。若没有登录，则拦截该方法，跳转到登录页面。
 */
public class MyInterceptor implements Interceptor {


    /**
     * return true:则执行真实对象的方法
     * return false: 调用around方法
     */
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("真实对象的方法执行前");
        System.out.println(target.getClass().getName());
        return ScyhAccountLib.getInstance() != null && ScyhAccountLib.getInstance().getApp() != null && ScyhAccountLib.getInstance().getApp().getAd_display() == 0;
//        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
//        System.out.println("取代被代理对象的方法,将真实对象的方法拦截,");
//        System.out.println("没有登录，该方法不能执行，正跳转登录页面...");
        IIfRequestAd IIfRequestAd = (IIfRequestAd) target;
        if (IIfRequestAd != null) {
            IIfRequestAd.AD();
        }
    }

    /**
     * 真实对象方法或者around方法执行之后，调用after方法。
     */
    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("真实对象的方法执行后");
    }
}