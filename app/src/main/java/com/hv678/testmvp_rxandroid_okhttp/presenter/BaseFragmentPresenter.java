package com.hv678.testmvp_rxandroid_okhttp.presenter;

import android.content.Context;

/**
 * Created by wuxm on 2016/3/8.
 * E-mail 380510218@qq.com
 */
public abstract class BaseFragmentPresenter<T> extends BasePresenter {
    public BaseFragmentPresenter() {

    }
    public void attach(Context context) {
        super.attach(context);
        this.loadDataFromDB();
        this.loadDataFromServer();
    }

    public void loadDataFromServer() {
    }

    public void loadDataFromDB() {
    }

    public void loadMoreData() {
    }

    protected void saveDataToDB(T datas) {
    }
}
