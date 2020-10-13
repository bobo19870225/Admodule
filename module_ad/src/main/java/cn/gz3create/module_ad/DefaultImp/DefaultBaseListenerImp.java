package cn.gz3create.module_ad.DefaultImp;

import com.ifmvo.togetherad.core.listener.BaseListener;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DefaultBaseListenerImp extends BaseListener {

    //一般不需要，所以为空实现
    @Override
    default void onAdStartRequest(@NotNull String providerType) {

    }


    //一般不需要，所以为空实现
    @Override
    default void onAdFailed(@NotNull String providerType, @Nullable String failedMsg) {

    }
}
