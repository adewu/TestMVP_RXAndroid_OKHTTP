package com.hv678.testmvp_rxandroid_okhttp.model;

import com.google.gson.Gson;
import com.hv678.testmvp_rxandroid_okhttp.bean.MeDetailBean;
import com.hv678.testmvp_rxandroid_okhttp.http.OKHttpClientManager;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by wuxm on 2016/1/25.
 * E-mail 380510218@qq.com
 */
public class UserModel {
    private Gson mGson = new Gson();

    public Observable<MeDetailBean> getUser(final String account, final String password) {
        return Observable.create(new Observable.OnSubscribe<MeDetailBean>() {

                                     @Override
                                     public void call(Subscriber<? super MeDetailBean> subscriber) {
                                         try {
                                             String url = "http://v.hv678.com/ws/signin";
                                             FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
                                             formEncodingBuilder.add("username", account);
                                             formEncodingBuilder.add("pwd", password);
                                             formEncodingBuilder.add("deviceid","2");
                                             formEncodingBuilder.add("devicetype","6");
                                             RequestBody formBody = formEncodingBuilder.build();
                                             Request request = new Request.Builder().url(url).post(formBody).build();
                                             Response response = OKHttpClientManager.getInstance().newCall(request);
                                             if (response.code() == 200) {
                                                 String string = response.body().string();
                                                 JSONObject result = new JSONObject(string);
                                                 String data = result.has("data") ? result.getString("data") : "";
                                                 data = data.replace("[", "");
                                                 data = data.replace("]", "");
                                                 MeDetailBean o = mGson.fromJson(data, MeDetailBean.class);
                                                 subscriber.onNext(o);
                                                 subscriber.onCompleted();
                                             } else {
                                                 //处理服务器异常
                                             }
                                         } catch (Exception e) {
                                             e.printStackTrace();
                                             subscriber.onError(e);
                                         }
                                     }
                                 }

        );
    }
}
