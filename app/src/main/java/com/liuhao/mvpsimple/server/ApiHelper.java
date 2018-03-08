package com.liuhao.mvpsimple.server;


import com.liuhao.mvpsimple.http.ApiFactory;
import com.liuhao.mvpsimple.http.ApiService;
import com.liuhao.mvpsimple.bean.RequestResult;

import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Api操作助手类
 */
public class ApiHelper {


    private static ApiService getApiService() {


        return ApiFactory.INSTANCE.getApiService();
    }


    /**
     * 加载所在城市的影讯
     */
    public static Observable<String> login(Map<String,Object> map) {
        return getApiService()
                .login(map)
                .subscribeOn(Schedulers.io())
                .map(new Func1<RequestResult<String>, String>() {
                    @Override
                    public String call(RequestResult<String> personRequestResult) {
                        if(personRequestResult.getCode() != 200){
                            /**
                             * 抛出业务异常
                             */
                            throw new ApiException(personRequestResult.getCode(), personRequestResult.getMsg());
                        }

                        return personRequestResult.getData();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }



}
