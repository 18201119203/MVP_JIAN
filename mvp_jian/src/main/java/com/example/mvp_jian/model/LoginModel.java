package com.example.mvp_jian.model;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.example.mvp_jian.api.UserApi;
import com.example.mvp_jian.contract.user.IRegActivity;
import com.example.mvp_jian.entity.UserEntity;
import com.example.mvp_jian.entity.Userreg;
import com.example.mvp_jian.interceptor.AppInterceptor;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class LoginModel implements IRegActivity.IloginModel {

    Handler handler = new Handler();

    @Override
    public void login(HashMap<String, String> params, final IRegActivity.RequestCallback callback) {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AppInterceptor())
                .addInterceptor(loggingInterceptor)
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();

        FormBody.Builder formBody = new FormBody.Builder();
        for (Map.Entry<String,String> p : params.entrySet()){
            formBody.add(p.getKey(),p.getValue());
        }

        Request request = new Request.Builder().url(UserApi.USER_LOGIN).post(formBody.build()).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.failure("网络可能不稳定,请稍后再试");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                int code = response.code();
                if (!TextUtils.isEmpty(result)){
                    paserResult(result,callback,code,UserEntity.class);
                }

            }
        });
    }


    private <T>void paserResult(String result, final IRegActivity.RequestCallback callback, int code,Class<T> clazz) {

        final T o = new Gson().fromJson(result, clazz);

        if (callback != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
//                    if (200 == code) {
                    callback.success(o);
//                    } else {
//                        callback.successMsg(userEntity.msg);
//                    }
                }
            });
        }
    }


    @Override
    public void reg(HashMap<String, String> params, final IRegActivity.RequestCallback requestCallback) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AppInterceptor())
                .addInterceptor(loggingInterceptor)
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();

        FormBody.Builder forBody = new FormBody.Builder();
        for (Map.Entry<String, String> p : params.entrySet()) {
            forBody.add(p.getKey(),p.getValue());
        }

        Request request = new Request.Builder().url(UserApi.USER_REG).post(forBody.build()).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (requestCallback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestCallback.failure("注册失败,网络可能不稳定,请稍后再试");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                if (requestCallback!=null){
                    String res = response.body().string();
                    int code = response.code();
                    if (!TextUtils.isEmpty(res)){
                        paserResult(res,requestCallback,code,Userreg.class);
                    }
                }

            }
        });


    }
}
