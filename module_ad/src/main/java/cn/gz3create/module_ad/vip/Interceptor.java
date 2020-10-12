package cn.gz3create.module_ad.vip;

import java.lang.reflect.Method;
//拦截器接口
public interface Interceptor {
    boolean before(Object proxy, Object target, Method method, Object[] args);

    void around(Object proxy, Object target, Method method, Object[] args);

    void after(Object proxy, Object target, Method method, Object[] args);
}