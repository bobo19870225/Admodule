package cn.gz3create.module_ad;

import android.os.Bundle;

import com.ifmvo.togetherad.core.helper.AdHelperBanner;
import com.ifmvo.togetherad.csj.CsjProvider;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cn.gz3create.module_ad.DefaultImp.DefaultBannerListenerImp;
import cn.gz3create.module_ad.view.AdDialog;

public class BaseExitActivity extends AppCompatActivity {
    private boolean isExit = false;
    private AdDialog adDialog;

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adDialog = new AdDialog(this);
        adDialog.setTitle("温馨提示");
        adDialog.setMessage("确定要退出吗？");
        adDialog.setOnClickBottomListener(new AdDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                adDialog.dismiss();
                isExit = true;
                onBackPressed();
            }

            @Override
            public void onNegtiveClick() {
                isExit = false;
                adDialog.dismiss();
            }
        });
        loadAd();
        adDialog.setOnDismissListener(dialog -> loadAd());
    }

    private void loadAd() {
        Map<String, Integer> radioMapBanner = new HashMap<>();
        radioMapBanner.put(AdProviderType.GDT.getType(), 0);
        radioMapBanner.put(AdProviderType.CSJ.getType(), 1);
        radioMapBanner.put(AdProviderType.BAIDU.getType(), 0);
        CsjProvider.Banner.INSTANCE.setExpressViewSize(300, 150);
        AdHelperBanner.INSTANCE.preloading(this, TogetherAdAlias.AD_BANNER, radioMapBanner, new DefaultBannerListenerImp() {
                    @Override
                    public void onAdFailedAll() {

                    }

                    @Override
                    public void onAdClose(@NotNull String providerType) {

                    }
                }
        );
    }


    @Override
    public void onBackPressed() {
        if (isExit) {
            super.onBackPressed();
        } else {
            adDialog.show();
        }
    }

    @Override
    @CallSuper
    protected void onDestroy() {
        super.onDestroy();
        AdHelperBanner.INSTANCE.destroy();
    }
}
