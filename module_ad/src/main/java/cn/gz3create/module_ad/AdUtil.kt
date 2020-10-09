package cn.gz3create.module_ad

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.ads.*
import com.ifmvo.togetherad.core.TogetherAd
import com.ifmvo.togetherad.core.custom.flow.AdImageLoader
import com.ifmvo.togetherad.core.helper.AdHelperSplash
import com.ifmvo.togetherad.core.listener.SplashListener
import com.ifmvo.togetherad.core.utils.ScreenUtil
import com.ifmvo.togetherad.core.utils.dp
import com.ifmvo.togetherad.csj.CsjProvider
import com.ifmvo.togetherad.csj.TogetherAdCsj
import java.lang.ref.WeakReference


class AdUtil private constructor() {
    //    private val tAg = "SplashActivity"
    private lateinit var interstitialAd: InterstitialAd
    private var INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-6377156563409469/5921704117"
    fun adInit(context: Context, appName: String) {
        interstitialAd = InterstitialAd(context)
//        if (BuildConfig.DEBUG) {
//            //    测试
//            INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"
//        }
        interstitialAd.adUnitId = INTERSTITIAL_AD_UNIT_ID


        /**
         * 自定义穿山甲的初始化配置
         * 可自行选择自定义穿山甲的配置，不配置就会使用穿山甲的默认值
         */
//        // 可选参数，需在初始化之前，使用TextureView控件播放视频,默认为SurfaceView,当有SurfaceView冲突的场景，可以使用TextureView
//        TogetherAdCsj.useTextureView = false
//        // 可选参数，需在初始化之前，标题栏的主题色
//        TogetherAdCsj.titleBarTheme = TTAdConstant.TITLE_BAR_THEME_DARK
//        // 可选参数，需在初始化之前，是否允许sdk展示通知栏提示
//        TogetherAdCsj.allowShowNotify = true
//        // 可选参数，需在初始化之前，是否在锁屏场景支持展示广告落地页
//        TogetherAdCsj.allowShowPageWhenScreenLock = true
//        // 可选参数，需在初始化之前，测试阶段打开，可以通过日志排查问题，上线时去除该调用
//        TogetherAdCsj.debug = true
//        // 可选参数，需在初始化之前，允许直接下载的网络状态集合
//        TogetherAdCsj.directDownloadNetworkType = TTAdConstant.NETWORK_STATE_WIFI or TTAdConstant.NETWORK_STATE_3G
//        // 可选参数，需在初始化之前，是否支持多进程，true支持
//        TogetherAdCsj.supportMultiProcess = false
//        // 可选参数，需在初始化之前，自定义网络库，demo中给出了okhttp3版本的样例，其余请自行开发或者咨询工作人员。
//        TogetherAdCsj.httpStack = object : IHttpStack {}
//        // 可选参数，需在初始化之前，设置是否为计费用户：true计费用户、false非计费用户。默认为false非计费用户。须征得用户同意才可传入该参数
//        TogetherAdCsj.isPaid = false
//        // 可选参数，需在初始化之前，是否一步初始化
//        TogetherAdCsj.isAsyncInit = false
//        // 可选参数，需在初始化之前，设置用户画像的关键词列表 **不能超过为1000个字符**。须征得用户同意才可传入该参数
//        TogetherAdCsj.keywords = ""
//        // 可选参数，需在初始化之前，设置额外的用户信息 **不能超过为1000个字符**
//        TogetherAdCsj.data = ""
//        //可选参数，需在初始化之前，可以设置隐私信息控制开关，需要重写其方法
//        TogetherAdCsj.customController = object : TTCustomController() {}

        //初始化穿山甲
        TogetherAdCsj.init(context = context, adProviderType = AdProviderType.CSJ.type, csjAdAppId = "5109683", appName = appName)
        //初始化广点通
//        TogetherAdGdt.init(context = context, adProviderType = AdProviderType.GDT.type, gdtAdAppId = "1101152570")
        //初始化百青藤
//        TogetherAdBaidu.init(context = context, adProviderType = AdProviderType.BAIDU.type, baiduAdAppId = "e866cfb0")

        /**
         * 配置所有广告位ID
         */
        TogetherAdCsj.idMapCsj = mapOf(
                TogetherAdAlias.AD_SPLASH to "887387422",
                TogetherAdAlias.AD_NATIVE_SIMPLE to "901121737",
                TogetherAdAlias.AD_NATIVE_RECYCLERVIEW to "901121737",
                TogetherAdAlias.AD_BANNER to "945513004",
                TogetherAdAlias.AD_INTER to "901121725",
                TogetherAdAlias.AD_REWARD to "901121365",
                TogetherAdAlias.AD_SPLASH_HYBRID to "901121737"//id是原生类型
        )

//        TogetherAdGdt.idMapGDT = mapOf(
//                TogetherAdAlias.AD_SPLASH to "8863364436303842593",
//                TogetherAdAlias.AD_NATIVE_SIMPLE to "6040749702835933",
//                TogetherAdAlias.AD_NATIVE_RECYCLERVIEW to "6040749702835933",
//                TogetherAdAlias.AD_BANNER to "4080052898050840",
//                TogetherAdAlias.AD_INTER to "1050691202717808",
//                TogetherAdAlias.AD_REWARD to "2090845242931421",
//                TogetherAdAlias.AD_SPLASH_HYBRID to "6040749702835933"//id是原生类型
//        )

//        TogetherAdBaidu.idMapBaidu = mapOf(
//                TogetherAdAlias.AD_SPLASH to "2058622",
//                TogetherAdAlias.AD_NATIVE_SIMPLE to "2058628",
//                TogetherAdAlias.AD_NATIVE_RECYCLERVIEW to "2058628",
//                TogetherAdAlias.AD_BANNER to "2015351",
//                TogetherAdAlias.AD_INTER to "2403633",
//                TogetherAdAlias.AD_REWARD to "5925490",
//                TogetherAdAlias.AD_SPLASH_HYBRID to "2058622"//id是开屏类型
//        )

        /**
         * 配置全局的广告商权重。
         * 如果在调用具体广告API时没有配置单次请求的权重，就会默认使用这个全局的权重
         * 如果不配置，TogetherAd会默认所有初始化的广告商权重相同
         *
         * 也可以在请求广告前设置，实时生效
         */
        TogetherAd.setPublicProviderRatio(mapOf(
                AdProviderType.GDT.type to 1,
                AdProviderType.BAIDU.type to 1,
                AdProviderType.CSJ.type to 1
        ))

        /**
         * 自定义图片加载方式
         * 用于自渲染类型的广告图片加载
         * 如果不配置，TogetherAd 会使用默认的图片加载方式
         * 主要考虑到：开发者可以自定义实现图片加载：渐变、占位图、错误图等
         */
        TogetherAd.setCustomImageLoader(object : AdImageLoader {
            override fun loadImage(context: Context, imageView: ImageView, imgUrl: String) {
                Glide.with(context).load(imgUrl).into(imageView)
            }
        })

        /**
         * 日志的开关
         * 全局实时生效
         */
        TogetherAd.printLogEnable = BuildConfig.DEBUG

        /**
         * 是否失败切换 （ 当请求广告失败时，是否允许切换到其他广告提供商再次请求 ）
         * 全局实时生效
         */
        TogetherAd.failedSwitchEnable = true

        /**
         * 最大拉取延时时间 ms（ 请求广告的超时时间 ）
         * 3000 ≤ value ≥ 10000（ 小于3000时按3000计算，大于10000时按10000计算 ）
         * 全局实时生效
         * 不设置代表没有超时时间
         */
        TogetherAd.maxFetchDelay = 5000
    }

    /**
     * 请求开屏广告
     */
    fun requestSplashAd(weakReference: WeakReference<out AppCompatActivity>, container: ViewGroup, listener: SplashListener? = null) {
        // Initialize the Mobile Ads SDK.
        if (weakReference.get() != null) {
            MobileAds.initialize(weakReference.get()) { }
        }

        val adRequest = AdRequest.Builder().build()
        interstitialAd.loadAd(adRequest)
        interstitialAd.adListener = object : AdListener() {
            override fun onAdLoaded() {
                interstitialAd.show()
            }

            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                Log.e("TAG", "onAdFailedToLoad: " + loadAdError.message)
                //开始请求开屏广告
                showCSJ(weakReference, container, listener)
            }

            override fun onAdClosed() {
                listener?.onAdDismissed("谷歌广告")
            }
        }


    }

    private fun showCSJ(WeakActivity: WeakReference<out AppCompatActivity>, container: ViewGroup, listener: SplashListener?) {
        /**
         * 设置 广点通 开屏广告 自定义跳过按钮
         * TogetherAd 提供了两个简单的实例模板，同时只能设置一个,如果设置多个后面的生效
         * 目前只有 优量汇(广点通) 支持自定义跳过按钮的样式，所以只会对 广点通 生效
         */
        //        GdtProvider.Splash.customSkipView = SplashSkipViewSimple2()
        //        GdtProvider.Splash.customSkipView = SplashSkipViewSimple1()
        /**
         * 设置 广点通 开屏广告超时时间
         * fetchDelay 参数，设置开屏广告从请求到展示所花的最大时长（并不是指广告曝光时长），
         * 取值范围为[3000, 5000]ms。
         * 如果需要使用默认值，可以给 fetchDelay 设为0或者不设置。
         */
        //        GdtProvider.Splash.maxFetchDelay = 0

        /**
         * 给 穿山甲 设置可接受的图片尺寸，避免图片变形
         * 一般设置容器的宽高即可
         */
        WeakActivity.get()?.let {
            CsjProvider.Splash.setImageAcceptedSize(ScreenUtil.getDisplayMetricsWidth(it), ScreenUtil.getDisplayMetricsHeight(it) - 100f.dp.toInt())
        }


        /**
         * 设置 穿山甲 开屏广告超时时间
         * fetchDelay 参数，设置开屏广告从请求到展示所花的最大时长（并不是指广告曝光时长），
         * 如果不设置，默认值为 3000ms
         */
        CsjProvider.Splash.maxFetchDelay = 5000

        //使用 Map<String, Int> 配置广告商 权重，通俗的讲就是 随机请求的概率占比
        val radioMapSplash: Map<String, Int> = mapOf(
                AdProviderType.GDT.type to 0,
                AdProviderType.CSJ.type to 1,
                AdProviderType.BAIDU.type to 0
        )

        /**
         * activity: 必传。这里不是 Context，因为广点通必须传 Activity，所以统一传 Activity。
         * alias: 必传。广告位的别名。初始化的时候是根据别名设置的广告ID，所以这里TogetherAd会根据别名查找对应的广告位ID。
         * radioMap: 非必传。广告商的权重。可以不传或传null，空的情况 TogetherAd 会自动使用初始化时 TogetherAd.setPublicProviderRadio 设置的全局通用权重。
         * container: 必传。请求到广告之后会自动添加到 container 这个布局中展示。
         * listener: 非必传。如果你不需要监听结果可以不传或传空。各个回调方法也可以选择性添加
         */
        WeakActivity.get()?.let { AdHelperSplash.show(activity = it, alias = TogetherAdAlias.AD_SPLASH, radioMapSplash, container = container, listener = listener) }
    }

    companion object {
        @JvmStatic
        @get:Synchronized
        val instance: AdUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            AdUtil()
        }
    }

}
