package com.liuhao.mvpsimple.mvpbase;

/**
 * Created by ${lhh} on 2017/11/27.
 */

public interface BaseMvpView {
    void showLoading();
    void hideLoading();
    void onError(String error);
}
