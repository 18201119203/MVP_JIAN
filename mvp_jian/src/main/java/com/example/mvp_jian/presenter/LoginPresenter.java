package com.example.mvp_jian.presenter;

import com.example.mvp_jian.action.MainActivity;
import com.example.mvp_jian.entity.UserEntity;
import com.example.mvp_jian.model.LoginModel;
import com.example.mvp_jian.net.RequestCallback;
import com.example.mvp_jian.view.IloginView;

import java.util.HashMap;

public class LoginPresenter {


    private LoginModel loginModel;
    private IloginView iloginView;

    public LoginPresenter(IloginView iloginView){
        loginModel = new LoginModel();
        this.iloginView = iloginView;

    }

    public void login(HashMap<String,String> params) {

        loginModel.login(params, new RequestCallback() {
            @Override
            public void failure(String msg) {
                iloginView.failure(msg);
            }

            @Override
            public void successMsg(String msg) {
                iloginView.success(msg);
            }

            @Override
            public void success(UserEntity userEntity) {
                iloginView.success(userEntity);
            }
        });


    }
}
