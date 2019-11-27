package com.bwie.zhouxinguang1127.until;
/*
 *@auther:周鑫光
 *@Date: 2019/11/27
 *@Time:8:49
 *@Description:${DESCRIPTION}
 * */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwie.zhouxinguang1127.app.Appcotion;

public class Until {
    //    封装单例
    private static final Until ourInstance = new Until();
    private final RequestQueue requestQueue;

    public static Until getInstance() {
        return ourInstance;
    }

    private Until() {
        requestQueue = Volley.newRequestQueue(Appcotion.context);
    }

    //封装get方法
    public void onget(String url, final MycallBack mycallBack) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mycallBack.onsuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mycallBack.onError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    //封装post方法
    public void onpost(String url, final MycallBack mycallBack) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mycallBack.onsuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mycallBack.onError(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    //    接口
    public interface MycallBack {
        void onsuccess(String json);

        void onError(String error);
    }

    //判断网络
    public boolean hasNet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return false;
        } else {
            return true;
        }

    }
}
