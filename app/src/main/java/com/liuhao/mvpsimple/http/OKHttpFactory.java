package com.liuhao.mvpsimple.http;//package network.enums;

import android.util.Log;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by ${lhh} on 2017/9/1.
 */




public enum OKHttpFactory {

  INSTANCE;

  private final OkHttpClient okHttpClient;


   OKHttpFactory() {

       okHttpClient = new OkHttpClient.Builder()
               .connectTimeout(15, TimeUnit.SECONDS)  //设置网络超时时间
               .writeTimeout(15, TimeUnit.SECONDS)   //写入超时
               .readTimeout(15, TimeUnit.SECONDS)    //读取超时

               //.cache(new Cache(directory, DEFAULT_CACHE_SIZE))
               .addInterceptor(LoggingInterceptorFactory.INTERCEPTOR.getInterceptor())
//               .addInterceptor(new HeaderInterceptor(context))
//               .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
               .build();
   }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }


}
