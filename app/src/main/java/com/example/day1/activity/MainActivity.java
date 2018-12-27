package com.example.day1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.day1.R;
import com.example.day1.xutils.BaseActivity;

public class MainActivity extends BaseActivity {


    private Button but_login;
    private Button but_reg;
    private EditText name;
    private EditText pwd;

    @Override
    protected void inifView() {

        but_login = findViewById(R.id.but_login);
        but_reg = findViewById(R.id.but_reg);
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);

        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        but_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void inifData() {



    }

    @Override
    protected int getContentId() {
        return R.layout.activity_main;
    }
}
