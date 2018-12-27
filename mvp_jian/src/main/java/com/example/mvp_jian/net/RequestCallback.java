package com.example.mvp_jian.net;

import com.example.mvp_jian.entity.UserEntity;

public interface RequestCallback {

    void failure(String msg);
    void successMsg(String msg);
    void success(UserEntity userEntity);

}
