package cn.gz3create.module_ad.DefaultImp;

import com.ifmvo.togetherad.core.listener.BannerListener;

import org.jetbrains.annotations.NotNull;

import cn.gz3create.scyh_account.ScyhAccountLib;
import cn.gz3create.scyh_account.utils.LibUtils;

public interface DefaultBannerListenerImp extends DefaultBaseListenerImp, BannerListener {
    @Override
    default void onAdLoaded(@NotNull String providerType) {

    }

    @Override
    default void onAdClicked(@NotNull String providerType) {
        ScyhAccountLib.getInstance().advReport(LibUtils.AdverCompany.ADV_FROM_CHUANSHANJIA, LibUtils.AdverType.ADV_TYPE_BANNER, 2);
    }

    @Override
    default void onAdExpose(@NotNull String providerType) {
        ScyhAccountLib.getInstance().advReport(LibUtils.AdverCompany.ADV_FROM_CHUANSHANJIA, LibUtils.AdverType.ADV_TYPE_BANNER, 1);
    }


}
