package cn.gz3create.module_ad.DefaultImp;

import com.ifmvo.togetherad.core.listener.RewardListener;

import org.jetbrains.annotations.NotNull;

import cn.gz3create.scyh_account.ScyhAccountLib;
import cn.gz3create.scyh_account.utils.LibUtils;

public interface DefaultRewardListenerImp extends DefaultBaseListenerImp , RewardListener {
    @Override
    default void onAdLoaded(@NotNull String providerType) {

    }

    @Override
    default void onAdClicked(@NotNull String providerType) {
        ScyhAccountLib.getInstance().advReport(LibUtils.AdverCompany.ADV_FROM_CHUANSHANJIA, LibUtils.AdverType.ADV_TYPE_VIDEO_AWARAD, 2);
    }

    @Override
    default void onAdShow(@NotNull String providerType) {
        ScyhAccountLib.getInstance().advReport(LibUtils.AdverCompany.ADV_FROM_CHUANSHANJIA, LibUtils.AdverType.ADV_TYPE_VIDEO_AWARAD, 1);
    }

    @Override
    default void onAdExpose(@NotNull String providerType) {

    }

    @Override
    default void onAdVideoComplete(@NotNull String providerType) {

    }

    @Override
    default void onAdVideoCached(@NotNull String providerType) {

    }

    @Override
    default void onAdRewardVerify(@NotNull String providerType) {

    }

    @Override
    default void onAdClose(@NotNull String providerType) {

    }
}
