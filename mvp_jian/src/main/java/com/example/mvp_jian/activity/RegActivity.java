package com.example.mvp_jian.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp_jian.R;
import com.example.mvp_jian.contract.user.IRegActivity;
import com.example.mvp_jian.entity.Userreg;
import com.example.mvp_jian.presenter.LoginPresenter;

import java.util.HashMap;

public class RegActivity extends AppCompatActivity implements IRegActivity.IregView {

    private EditText name;
    private EditText pwd;
    private String mobile;
    private String password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();

    }

    private void initView() {
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);

    }

    private void initData() {
        presenter = new LoginPresenter(this);

    }

    public void but_reg(View view) {
        mobile = name.getText().toString();
        password = pwd.getText().toString();

        HashMap<String,String> params = new HashMap<>();
        params.put("mobile",mobile);
        params.put("password",password);
        presenter.register(params);

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
    public void success(Userreg userEntity) {
        Toast.makeText(this,userEntity.msg+"",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void success(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
