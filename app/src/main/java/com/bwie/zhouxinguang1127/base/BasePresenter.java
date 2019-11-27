package com.bwie.zhouxinguang1127.base;
/*
 *@auther:周鑫光
 *@Date: 2019/11/27
 *@Time:8:55
 *@Description:${DESCRIPTION}
 * */

import com.bwie.zhouxinguang1127.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contract.Iview> implements Contract.Presenter {
    protected WeakReference<V> weakReference;

    public BasePresenter() {
        inisModel();
    }

    protected void onAttach(V iview) {
        weakReference = new WeakReference<>(iview);
    }

    protected void onDesAttach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    protected abstract void inisModel();

    protected V get() {
        return weakReference.get();
    }
}
