package com.bwie.zhouxinguang1127;
/*
 *@auther:周鑫光
 *@Date: 2019/11/27
 *@Time:10:19
 *@Description:${DESCRIPTION}
 * */

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

public class CacheHandlle implements Thread.UncaughtExceptionHandler {
    private Context context;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private static final CacheHandlle ourInstance = new CacheHandlle();

    public static CacheHandlle getInstance() {
        return ourInstance;
    }

    private CacheHandlle() {

    }

    public void init(Context context) {
        this.context = context;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }


    public Boolean han(Throwable e) {
        if (e == null) {
            return false;
        } else {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    Looper.prepare();
                    Toast.makeText(context, "程序异常,程序即将异常", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }.start();
        }
        return true;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (!han(e) && uncaughtExceptionHandler == null) {
            uncaughtException(t, e);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }

    }
}
