package com.example.mvp_jian.contract.user;

import com.example.mvp_jian.entity.UserEntity;
import com.example.mvp_jian.entity.Userreg;

import java.util.HashMap;

public interface IRegActivity {

    public abstract class regpresenter {
        public abstract void login(HashMap<String, String> params);
        public abstract void register(HashMap<String,String> params);
    }


    interface IloginView{

        void mobileError(String msg);
        void pwdError(String msg);
        void failure(String msg);
        void success(UserEntity userEntity);
        void success(String msg);

    }
    interface IregView{

        void mobileError(String msg);
        void pwdError(String msg);
        void failure(String msg);
        void success(Userreg userEntity);
        void success(String msg);

    }

    interface IloginModel{

        void login(HashMap<String, String> params, IRegActivity.RequestCallback requestCallback);
        void reg(HashMap<String,String> params,IRegActivity.RequestCallback requestCallback);

    }

    interface RequestCallback{
        void failure(String msg);
        void successMsg(String msg);
        void success(Object userEntity);

    }



}
