package com.liuhao.mvpsimple.mvpbase;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.liuhao.mvpsimple.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${lhh} on 2017/11/27.
 */

public abstract class BaseMvpActivity <V extends BaseMvpView,T extends BaseMvpPresenter<V>> extends AppCompatActivity {
    public T presenter;

    private Dialog loadDialog;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        presenter = initPresenter();
        presenter.attach((V)this);
        bind = ButterKnife.bind(this);

        init();
    }



    @Override
    protected void onDestroy() {
        presenter.dettach();
        if(bind != null)
            bind.unbind();
        super.onDestroy();
    }

    protected void toast(String toast){
        Toast.makeText(this,toast,Toast.LENGTH_SHORT).show();
    }


    protected void show(){
        if(loadDialog == null) {

            loadDialog = new Dialog(this, R.style.MyDialogStyle);
            loadDialog.setContentView(getProgressBar());

        }
        loadDialog.show();
    }

    private View getProgressBar() {
        ProgressBar progressBar = new ProgressBar(this,null,android.R.attr.progressBarStyle);
        Drawable drawable = getResources().getDrawable(R.drawable.progressbar_color);
        progressBar.setIndeterminateDrawable(drawable);
        return progressBar;
    }

    protected void dismiss(){
        if(loadDialog != null && loadDialog.isShowing())
            loadDialog.dismiss();
    }



    // 实例化presenter
    public abstract T initPresenter();

    public abstract int getLayout();
    public abstract void init();
}