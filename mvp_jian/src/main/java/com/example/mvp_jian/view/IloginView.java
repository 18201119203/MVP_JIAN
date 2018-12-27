package com.example.mvp_jian.view;

import com.example.mvp_jian.entity.UserEntity;

public interface IloginView {

    void mobileError(String msg);
    void pwdError(String msg);
    void failure(String msg);
    void success(UserEntity userEntity);
    void success(String msg);

}
