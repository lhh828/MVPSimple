package com.liuhao.mvpsimple.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.liuhao.mvpsimple.http.ProgressRequestBody;
import com.liuhao.mvpsimple.http.ProgressRequestListener;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by ${lhh} on 2017/9/28.
 */

public class UploadPresenter {

    public void upload(final Context context , File file, final ImageView imageView , String type_name, ProgressRequestListener listener) {

        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)//表单类型
                .addFormDataPart("app", "common")// 自定义参数
                .addFormDataPart("act", "upload_image")
                .addFormDataPart("type_name", type_name)
                .addFormDataPart("save_type", "1");


        RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        builder.addFormDataPart("image", file.getName(), imageBody);//imgfile 后台接收图片流的参数名

        MultipartBody requestBody = builder.build();
        ProgressRequestBody bod = new ProgressRequestBody(requestBody, listener);
        //构建请求
        Request request = new Request.Builder()
                .url("上传地址")//地址
                .post(bod)//添加请求体
                .build();

        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {

            }
        });

    }

}
