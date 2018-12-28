package com.example.mvp_jian.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp_jian.R;
import com.example.mvp_jian.contract.user.IRegActivity;
import com.example.mvp_jian.entity.UserEntity;
import com.example.mvp_jian.presenter.LoginPresenter;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements IRegActivity.IloginView {

    //叫偶分
    private LoginPresenter presenter;
    private EditText name;
    private EditText pwd;
    private String mobile;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    /**
     * 初始化view
     */
    private void initView(){
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);

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

        mobile = name.getText().toString();
        password = pwd.getText().toString();
        HashMap<String,String> params = new HashMap<>();
        params.put("mobile",mobile);
        params.put("password",password);

        if (presenter!=null){
            presenter.login(params);
        }

    }
    public void regBtn(View view){

        startActivity(new Intent(LoginActivity.this,RegActivity.class));

    }


    @Override
    public void mobileError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(UserEntity userEntity) {
        Toast.makeText(this,userEntity.msg+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
