package com.hv678.testmvp_rxandroid_okhttp.mvpview;

/**
 * Created by wuxm on 2016/3/8.
 * E-mail 380510218@qq.com
 */
public interface MvpBaseHttpView {
    void onRequestStart();
//    void onSuccess();
//    void onError();
    void onRequestEnd();
}
