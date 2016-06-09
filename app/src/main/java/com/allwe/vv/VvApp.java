package com.allwe.vv;

import android.app.Application;
import android.graphics.Bitmap;

import com.allwe.vv.config.C;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;

/**
 * Created by taotao on 16-6-8.
 */

public class VvApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        File cacheDir = com.nostra13.universalimageloader.utils.StorageUtils
                .getOwnCacheDirectory(getApplicationContext(),
                        C.IMAGE_CACHE_PATH);
        DisplayImageOptions defaultOptions= new DisplayImageOptions.Builder()
                .showStubImage(R.mipmap.head_icon)
                .showImageForEmptyUri(R.mipmap.head_icon)
                .showImageOnFail(R.mipmap.head_icon)
                .cacheInMemory(true).cacheOnDisc(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY).build();;

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                this).defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new LruMemoryCache(12 * 1024 * 1024))
                .memoryCacheSize(12 * 1024 * 1024)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);

    }
}
