package cn.gz3create.module_ad.vip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ifmvo.togetherad.core.helper.AdHelperReward;
import com.ifmvo.togetherad.core.listener.RewardListener;

import java.util.Map;

import androidx.annotation.NonNull;
import cn.gz3create.module_ad.view.AdDialog;

public class VipDialog extends AdDialog {
    public VipDialog(@NonNull Activity activity) {
        super(activity);
//        loadAd(alias, ratioMap, listener);
    }

    private OnVIPClickListener onVIPClickListener;
    private AdHelperReward adHelperReward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //必须先调用这个方法
    public void loadAd(String alias, Map<String, Integer> ratioMap, RewardListener listener) {
        if (adHelperReward == null) {
            adHelperReward = new AdHelperReward(activity, alias, ratioMap, listener);
        }
        adHelperReward.load();
    }

    @Override
    protected void initView() {
        super.initView();
        close.setVisibility(View.VISIBLE);
        setNegtive("查看广告");
        setPositive("开通VIP");
        setOnClickBottomListener(new OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                if (onVIPClickListener != null) {
                    onVIPClickListener.onClick();
                }
            }

            @Override
            public void onNegtiveClick() {
                adHelperReward.show();
            }
        });
    }

    public void setOnVIPClickListener(OnVIPClickListener onVIPClickListener) {
        this.onVIPClickListener = onVIPClickListener;
    }

    public interface OnVIPClickListener {
        /**
         * 点击开通VIP按钮事件
         */
        void onClick();
    }

}
