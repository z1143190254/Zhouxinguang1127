package com.bwie.zhouxinguang1127.model;
/*
 *@auther:周鑫光
 *@Date: 2019/11/27
 *@Time:8:55
 *@Description:${DESCRIPTION}
 * */

import com.bwie.zhouxinguang1127.Contract;
import com.bwie.zhouxinguang1127.until.Until;

public class Imodel implements Contract.IModel {
    @Override
    public void onget(String url, final Contract.MycallBack mycallBack) {
        Until.getInstance().onget(url, new Until.MycallBack() {
            @Override
            public void onsuccess(String json) {
                mycallBack.onsuccess(json);
            }

            @Override
            public void onError(String error) {
                mycallBack.onError(error);
            }
        });
    }

    @Override
    public void onpost(String url, Contract.MycallBack mycallBack) {

    }
}
