package chengang.library.gilde;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.request.target.ViewTarget;

import java.io.InputStream;

import chengang.library.App;
import chengang.library.R;

/**
 * Glide自定义配置
 * <p>
 * Created by fengchengang on 2017/6/27.
 */

public class GlideConfiguration implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // 设置别的get/set tag id，以免占用View默认的
        ViewTarget.setTagId(R.id.glide_tag_id);

        //解决压缩图片后颜色变绿的问题
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        /*
        内存缓存
        Glide提供了一个类MemorySizeCalculator，用于决定内存缓存大小以及 bitmap 的缓存池。
        bitmap 池维护了你 App 的堆中的图像分配。
        正确的 bitmpa 池是非常必要的，因为它避免很多的图像重复回收，这样可以确保垃圾回收器的管理更加合理。
        它的默认计算实现
        */
        MemorySizeCalculator memorySizeCalculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = memorySizeCalculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = memorySizeCalculator.getBitmapPoolSize();
        builder.setMemoryCache(new LruResourceCache((int) (defaultMemoryCacheSize*1.2f)));
        builder.setBitmapPool(new LruBitmapPool((int) (defaultBitmapPoolSize * 1.2f)));

        /*
        磁盘缓存
        Glide图片缓存有两种情况，一种是内部磁盘缓存另一种是外部磁盘缓存。
        我们可以通过 builder.setDiskCache（）设置，并且Glide已经封装好了两个类实现外部和内部磁盘缓存，
        分别是InternalCacheDiskCacheFactory和ExternalCacheDiskCacheFactory
         */
        //磁盘缓存50M，默认250M
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, 50 * 1024 * 1024));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        App application = (App) context.getApplicationContext();
        //Glide 底层默认使用 HttpConnection 进行网络请求,这里替换为 Okhttp 后才能使用本框架,进行 Glide 的加载进度监听
        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(application.getOkHttpClient()));
    }
}
