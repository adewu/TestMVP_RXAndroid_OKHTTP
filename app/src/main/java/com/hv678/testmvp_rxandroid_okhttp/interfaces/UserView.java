package com.hv678.testmvp_rxandroid_okhttp.interfaces;

import com.hv678.testmvp_rxandroid_okhttp.bean.MeDetailBean;

/**
 * Created by wuxm on 2016/1/25.
 * E-mail 380510218@qq.com
 */
public interface UserView {
    void updateView(MeDetailBean user);

    void showProgressDialog();

    void hideProgressDialog();

    void showError(String msg);
}
