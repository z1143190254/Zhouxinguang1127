package com.bwie.zhouxinguang1127.app;
/*
 *@auther:周鑫光
 *@Date: 2019/11/27
 *@Time:8:49
 *@Description:${DESCRIPTION}
 * */

import android.app.Application;
import android.content.Context;

import com.bwie.zhouxinguang1127.CacheHandlle;

public class Appcotion extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        CacheHandlle.getInstance().init(context);
    }
}
