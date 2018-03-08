package com.liuhao.mvpsimple.presenter;

import com.liuhao.mvpsimple.server.ApiException;
import com.liuhao.mvpsimple.server.ApiHelper;
import com.liuhao.mvpsimple.server.ApiSubscriber;
import com.liuhao.mvpsimple.view.IMainView;
import com.liuhao.mvpsimple.mvpbase.BaseMvpPresenter;

import java.util.Map;

/**
 * Created by ${lhh} on 2017/11/27.
 */

public class LoginPresenter extends BaseMvpPresenter<IMainView> {

    private int mErrCode;

    public void login(Map<String, Object> map){

        if(mView != null)
            mView.showLoading();

        ApiHelper.login(map)
                .subscribe(new ApiSubscriber<String>() {
                    @Override
                    protected void onError(String msg) {
                        //错误消息
                        if(mView != null)
                            mView.onError(msg);
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onNext(String token) {
                        if(mView != null) {
                            mView.hideLoading();
                            mView.loginBack("登录成功：token="+token);
                        }
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof ApiException) {
                            mErrCode = ((ApiException) e).getCode();
                        }
                        super.onError(e);
                    }


                });


    }
}
