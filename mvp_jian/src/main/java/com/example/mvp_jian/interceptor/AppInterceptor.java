package com.example.mvp_jian.interceptor;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AppInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();//得到开发者创建的request对象

        //得到原来的response对象
        Response response = chain.proceed(request);

//        Response response1 = response.newBuilder().build();
//        Log.d("result:",response1.body().string());
        return response;
    }
}
