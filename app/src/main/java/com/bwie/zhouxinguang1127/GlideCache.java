package com.bwie.zhouxinguang1127;
/*
 *@auther:周鑫光
 *@Date: 2019/11/27
 *@Time:10:05
 *@Description:${DESCRIPTION}
 * */

import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

public class GlideCache implements GlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        int MyCache = 1021 * 1021 * 20;
        File file = new File(Environment.getExternalStorageDirectory(), "mycahce");
        String path = file.getPath();
        builder.setDiskCache(new DiskLruCacheFactory(path, MyCache));
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {

    }
}
