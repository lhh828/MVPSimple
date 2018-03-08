package com.liuhao.mvpsimple.http;


import com.liuhao.mvpsimple.bean.RequestResult;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by ${lhh} on 2017/9/2.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("index.php")
    Observable<RequestResult<String>> login(@FieldMap Map<String,Object> map);
}
