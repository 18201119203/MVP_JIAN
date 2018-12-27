package com.example.mvp_jian.model;

import com.example.mvp_jian.net.RequestCallback;

import java.util.HashMap;

public interface IloginModel {

    void login(HashMap<String, String> params, RequestCallback requestCallback);

}
