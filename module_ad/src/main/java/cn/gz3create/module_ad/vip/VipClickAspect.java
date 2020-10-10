package cn.gz3create.module_ad.vip;//package cn.gz3create.module_ad.vip;
//
//import android.util.Log;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//
////新建切面
//@Aspect
//public class VipClickAspect {
////cn/gz3create/module_ad/vip/ChickVIPAnnotation.java
////    private final String POINT_CUT_DOUBLE_CLICK = "execution(@com.suning.jr.aoptest.DoubleClickAnnotation * *(..))";
//    private final String POINT_CUT_DOUBLE_CLICK = "execution(@cn.gz3create.module_ad.vip.ChickVIPAnnotation * *(..))";
//    //切入点
//    @Pointcut(POINT_CUT_DOUBLE_CLICK)
//    public void vipClick() {
//        Log.e("KKKk", "点击");
//    }
//
//    //advice通知
//    @Around("vipClick()")
//    public void execute(ProceedingJoinPoint joinPoint) {
//        try {
//            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//            ChickVIPAnnotation annotation = signature.getMethod()
//                    .getAnnotation(ChickVIPAnnotation.class);
//            if (annotation != null) {
//                //处理自己的逻辑
//                Log.e("KKKk", "点击拦截");
//            }
//            joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }
//}