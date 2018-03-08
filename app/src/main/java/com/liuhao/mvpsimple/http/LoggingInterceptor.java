package com.liuhao.mvpsimple.http;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ${lhh} on 2017/9/1.
 * 日志拦截器
 */

public class LoggingInterceptor implements Interceptor {

    private final Logger mLogger;

    public LoggingInterceptor() {
        mLogger = Logger.getLogger("Okhttp");
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();

//        final Request requestWithUserAgent = originalRequest.newBuilder()
                //移除先前默认的UA
//                .removeHeader(USER_AGENT_HEADER_NAME)
               //设置UA
//                .addHeader(USER_AGENT_HEADER_NAME, userAgentHeaderValue)
//               .build();

        Response response = chain.proceed(request);
        mLogger.info(request.url().encodedPath());
        return response;
   }


}
