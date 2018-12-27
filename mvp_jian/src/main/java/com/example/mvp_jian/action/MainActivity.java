package com.example.mvp_jian.action;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mvp_jian.R;
import com.example.mvp_jian.entity.UserEntity;
import com.example.mvp_jian.presenter.LoginPresenter;
import com.example.mvp_jian.view.IloginView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements IloginView {

    //叫偶分
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * 初始化数据
     */
    private void initData() {
        presenter = new LoginPresenter(this);
    }

    /**
     * 点击，登录
     * @param view
     */
    public void login(View view) {

        HashMap<String,String> params = new HashMap<>();
        params.put("mobile","18612991023");
        params.put("password","111111");

        if (presenter!=null){
            presenter.login(params);
        }

    }



    @Override
    public void mobileError(String msg) {

    }

    @Override
    public void pwdError(String msg) {

    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void success(UserEntity userEntity) {

    }

    @Override
    public void success(String msg) {

    }
}
