package cn.gz3create.module_ad

import android.app.Activity
import android.view.ViewGroup

import com.ifmvo.togetherad.core.TogetherAd
import com.ifmvo.togetherad.core.config.AdProviderLoader
import com.ifmvo.togetherad.core.listener.BannerListener
import com.ifmvo.togetherad.core.provider.BaseAdProvider
import com.ifmvo.togetherad.core.utils.AdRandomUtil
import com.ifmvo.togetherad.core.utils.loge
import org.jetbrains.annotations.NotNull

/**
 * Banner 横幅广告
 */
object AdHelperBanner : BaseHelper() {

    private var adProvider: BaseAdProvider? = null

    //为了照顾 Java 调用的同学
    fun show(@NotNull activity: Activity, @NotNull alias: String, @NotNull container: ViewGroup, listener: BannerListener? = null) {
        show(activity, alias, null, container, listener)
    }

    fun show(@NotNull activity: Activity, @NotNull alias: String, radioMap: Map<String, Int>? = null, @NotNull container: ViewGroup, listener: BannerListener? = null) {
        startTimer(listener)
        realShow(activity, alias, radioMap, container, listener)
    }

    private fun realShow(@NotNull activity: Activity, @NotNull alias: String, radioMap: Map<String, Int>? = null, @NotNull container: ViewGroup, listener: BannerListener? = null) {

        val currentRadioMap = if (radioMap?.isEmpty() != false) TogetherAd.getPublicProviderRadio() else radioMap

        val adProviderType = AdRandomUtil.getRandomAdProvider(currentRadioMap)

        if (adProviderType?.isEmpty() != false) {
            cancelTimer()
            listener?.onAdFailedAll()
            return
        }

        adProvider = AdProviderLoader.loadAdProvider(adProviderType)

        if (adProvider == null) {
            "$adProviderType ${activity.getString(R.string.no_init)}".loge()
            val newRadioMap = filterType(currentRadioMap, adProviderType)
            realShow(activity, alias, newRadioMap, container, listener)
            return
        }

        adProvider?.showBannerAd(activity = activity, adProviderType = adProviderType, alias = alias, container = container, listener = object : BannerListener {
            override fun onAdStartRequest(providerType: String) {
                listener?.onAdStartRequest(adProviderType)
            }

            override fun onAdLoaded(providerType: String) {
                if (isFetchOverTime) return

                cancelTimer()
                listener?.onAdLoaded(providerType)
            }

            override fun onAdFailed(providerType: String, failedMsg: String?) {
                if (isFetchOverTime) return

                listener?.onAdFailed(providerType, failedMsg)
                val newRadioMap = filterType(currentRadioMap, adProviderType)
                realShow(activity, alias, newRadioMap, container, listener)
            }

            override fun onAdClicked(providerType: String) {
                listener?.onAdClicked(providerType)
            }

            override fun onAdExpose(providerType: String) {
                listener?.onAdExpose(providerType)
            }

            override fun onAdClose(providerType: String) {
                listener?.onAdClose(providerType)
            }
        })
    }

    fun destroy() {
        adProvider?.destroyBannerAd()
        adProvider = null
    }
}