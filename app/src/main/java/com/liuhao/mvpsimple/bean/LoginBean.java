package com.liuhao.mvpsimple.bean;

import java.io.Serializable;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/8/2.
 */
//登录
public class LoginBean implements Serializable {


    private int code;
    private String msg;
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
