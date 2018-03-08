package com.liuhao.mvpsimple.http;

import android.util.Log;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by ${lhh} on 2017/9/2.
 * 日志拦截器单例工厂
 */

public enum LoggingInterceptorFactory {
    INTERCEPTOR;

    private final HttpLoggingInterceptor interceptor;
    LoggingInterceptorFactory() {

        //日志显示级别
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("info","OkHttp====Message:"+message);
            }
        });
        interceptor.setLevel(level);
    }

    public Interceptor getInterceptor() {
        return interceptor;
    }
}
