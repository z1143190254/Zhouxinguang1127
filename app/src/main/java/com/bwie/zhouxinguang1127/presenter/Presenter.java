package com.bwie.zhouxinguang1127.presenter;
/*
 *@auther:周鑫光
 *@Date: 2019/11/27
 *@Time:8:55
 *@Description:${DESCRIPTION}
 * */

import com.bwie.zhouxinguang1127.Contract;
import com.bwie.zhouxinguang1127.base.BasePresenter;
import com.bwie.zhouxinguang1127.model.Imodel;

public class Presenter extends BasePresenter {

    private Contract.IModel imodel;

    @Override
    protected void inisModel() {
        imodel = new Imodel();
    }

    @Override
    public void onstart(String url) {
        imodel.onget(url, new Contract.MycallBack() {
            @Override
            public void onsuccess(String json) {
                get().onsuccess(json);
            }

            @Override
            public void onError(String error) {
                get().onError(error);
            }
        });

    }
}
