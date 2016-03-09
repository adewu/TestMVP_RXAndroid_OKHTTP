package com.hv678.testmvp_rxandroid_okhttp.presenter;

import android.os.Bundle;

/**
 * Created by wuxm on 2016/3/8.
 * E-mail 380510218@qq.com
 */
public interface  BaseActivityPresenter {
    void onCreate(Bundle bundle);

    void onResume();

    void onDestroy();
}
