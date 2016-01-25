package com.hv678.testmvp_rxandroid_okhttp.presenter;

import com.hv678.testmvp_rxandroid_okhttp.bean.MeDetailBean;
import com.hv678.testmvp_rxandroid_okhttp.interfaces.UserView;
import com.hv678.testmvp_rxandroid_okhttp.model.UserModel;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wuxm on 2016/1/25.
 * E-mail 380510218@qq.com
 */
public class UserPresenter {
    private UserView mUserView;
    private UserModel mUserModel;

    public UserPresenter(UserView mUserView) {
        this.mUserView = mUserView;
        mUserModel = new UserModel();
    }

    public void getUser(final String account,final String password){
        mUserModel.getUser(account,password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<MeDetailBean>() {
            @Override
            public void onCompleted() {
                mUserView.hideProgressDialog();
            }

            @Override
            public void onError(Throwable e) {
                mUserView.showError(e.getMessage());
                mUserView.hideProgressDialog();
            }

            @Override
            public void onNext(MeDetailBean meDetailBean) {
                mUserView.updateView(meDetailBean);
            }
        });
    }
}
