package com.liuhao.mvpsimple;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.liuhao.mvpsimple.mvpbase.BaseMvpActivity;
import com.liuhao.mvpsimple.presenter.LoginPresenter;
import com.liuhao.mvpsimple.utils.CacheUtil;
import com.liuhao.mvpsimple.view.IMainView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseMvpActivity<IMainView,LoginPresenter> implements IMainView {



    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {

        Log.d("info",CacheUtil.getCacheDirectory(this, Environment.DIRECTORY_PICTURES).getAbsolutePath());
        Log.d("info","picture :"+ CacheUtil.getExternalCacheDirectory(this, Environment.DIRECTORY_PICTURES).getAbsolutePath());
        Log.d("info","null :"+ CacheUtil.getExternalCacheDirectory(this, null).getAbsolutePath());
        Log.d("info","picture :"+ CacheUtil.getInternalCacheDirectory(this, Environment.DIRECTORY_PICTURES).getAbsolutePath());
        Log.d("info","null :"+ CacheUtil.getInternalCacheDirectory(this, null).getAbsolutePath());
    }

    @Override
    public void loginBack(String str) {
        toast(str);
    }

    @Override
    public void showLoading() {
        show();
    }

    @Override
    public void hideLoading() {
        dismiss();
    }

    @Override
    public void onError(String error) {
        toast(error);
        dismiss();
    }


    public void loginClick(View view){
        Map<String, Object> map = new HashMap<>();
        map.put("act","login");
        map.put("user_name","13691826383");
        map.put("password","123456");
        presenter.login(map);
    }


}
