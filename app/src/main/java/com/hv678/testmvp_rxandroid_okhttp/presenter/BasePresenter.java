package com.hv678.testmvp_rxandroid_okhttp.presenter;

import android.app.Activity;
import android.content.Context;

/**
 * Created by wuxm on 2016/3/8.
 * E-mail 380510218@qq.com
 */
public abstract class BasePresenter {
    protected Context mContext;

    public BasePresenter() {
    }

    public void attach(Context context) {
        this.mContext = context;
    }

    public void detach() {
        this.mContext = null;
    }

    protected boolean isActivityAlive() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            return !activity.isFinishing();
        } else {
            return false;
        }
    }
}
