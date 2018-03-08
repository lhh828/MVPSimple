package com.liuhao.mvpsimple.http;//package network.enums;


/**
* Created by ${lhh} on 2017/9/1.
 *
 * */

public enum ApiFactory {
    INSTANCE;


   private final ApiService apiService;

   ApiFactory() {
       apiService = RetrofitClient.INSTANCE.getRetrofit().create(ApiService.class);
   }

   public ApiService getApiService() {
        return apiService;
   }

}
