package com.hv678.testmvp_rxandroid_okhttp.http;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wuxm on 2016/1/25.
 * E-mail 380510218@qq.com
 */
public class OKHttpClientManager {
    private static final String TAG = "OkHttpClientManager";

    private static OKHttpClientManager mInstance;
    private OkHttpClient mOkHttpClient;


    private OKHttpClientManager() {
        mOkHttpClient = new OkHttpClient();
        mOkHttpClient.setConnectTimeout(5L, TimeUnit.SECONDS);
    }

    public static OKHttpClientManager getInstance() {
        if (mInstance == null) {
            synchronized (OKHttpClientManager.class) {
                if (mInstance == null) {
                    mInstance = new OKHttpClientManager();
                }
            }
        }
        return mInstance;
    }

    public Response newCall(Request r){
        try {
            return mOkHttpClient.newCall(r).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
