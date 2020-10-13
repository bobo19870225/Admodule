package cn.gz3create.module_ad.DefaultImp;

import com.ifmvo.togetherad.core.listener.SplashListener;

import org.jetbrains.annotations.NotNull;

import cn.gz3create.scyh_account.ScyhAccountLib;
import cn.gz3create.scyh_account.utils.LibUtils;

public interface DefaultSplashListenerImp extends DefaultBaseListenerImp, SplashListener {
    @Override
    default void onAdLoaded(@NotNull String providerType) {

    }

    @Override
    default void onAdClicked(@NotNull String providerType) {
        ScyhAccountLib.getInstance().advReport(LibUtils.AdverCompany.ADV_FROM_CHUANSHANJIA, LibUtils.AdverType.ADV_TYPE_APPSTART, 2);
    }

    @Override
    default void onAdExposure(@NotNull String providerType) {
        ScyhAccountLib.getInstance().advReport(LibUtils.AdverCompany.ADV_FROM_CHUANSHANJIA, LibUtils.AdverType.ADV_TYPE_APPSTART, 1);
    }

    @Override
    default void onAdDismissed(@NotNull String providerType) {

    }
}
