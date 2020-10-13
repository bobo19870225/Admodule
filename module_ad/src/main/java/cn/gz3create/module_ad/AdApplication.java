package cn.gz3create.module_ad;

import android.app.Application;

import java.util.Map;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import cn.gz3create.scyh_account.ScyhAccountLib;

public abstract class AdApplication extends Application {
    @Override
    @CallSuper
    public void onCreate() {
        super.onCreate();
        AdUtil.getInstance().adInit(this, setAppNameAndAdKey());
        ScyhAccountLib.initLib(this, setAppId(), setUMKey());
    }

    @NonNull
    protected abstract Map<String, String> setUMKey();

    @NonNull
    protected abstract String setAppId();

    @NonNull
    protected abstract Map<String, String> setAppNameAndAdKey();
}
