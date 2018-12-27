package com.example.day1.xutils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentId());

        inifView();
        inifData();
    }

    protected abstract void inifView();

    protected abstract void inifData();

    protected abstract int getContentId();
}
