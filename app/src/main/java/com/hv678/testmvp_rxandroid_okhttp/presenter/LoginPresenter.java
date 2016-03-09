package com.hv678.testmvp_rxandroid_okhttp.presenter;

import android.os.Bundle;

import com.hv678.testmvp_rxandroid_okhttp.bean.MeDetailBean;
import com.hv678.testmvp_rxandroid_okhttp.mvpview.MvpLoginView;
import com.hv678.testmvp_rxandroid_okhttp.model.UserModel;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wuxm on 2016/1/25.
 * E-mail 380510218@qq.com
 */
public class LoginPresenter implements BaseActivityPresenter {
    private MvpLoginView mMvpLoginView;
    private UserModel mUserModel;

    public LoginPresenter(MvpLoginView mMvpLoginView) {
        this.mMvpLoginView = mMvpLoginView;
        mUserModel = new UserModel();
    }

    public void getUser(final String account,final String password){
        mUserModel.getUser(account,password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<MeDetailBean>() {
            @Override
            public void onCompleted() {
                mMvpLoginView.hideProgressDialog();
            }

            @Override
            public void onError(Throwable e) {
                mMvpLoginView.showError(e.getMessage());
                mMvpLoginView.hideProgressDialog();
            }

            @Override
            public void onNext(MeDetailBean meDetailBean) {
                mMvpLoginView.updateView(meDetailBean);
            }
        });
    }

    @Override
    public void onCreate(Bundle bundle) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
