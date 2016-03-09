package com.hv678.testmvp_rxandroid_okhttp.mvpview;

import com.hv678.testmvp_rxandroid_okhttp.bean.MeDetailBean;

/**
 * Created by wuxm on 2016/1/25.
 * E-mail 380510218@qq.com
 */
public interface MvpLoginView extends MvpBaseProgressDialogView {
    void updateView(MeDetailBean user);
    void showError(String msg);
}
