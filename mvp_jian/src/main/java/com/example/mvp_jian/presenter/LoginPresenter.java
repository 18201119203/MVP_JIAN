package com.example.mvp_jian.presenter;

import com.example.mvp_jian.contract.user.IRegActivity;
import com.example.mvp_jian.entity.UserEntity;
import com.example.mvp_jian.entity.Userreg;
import com.example.mvp_jian.model.LoginModel;
import com.example.mvp_jian.utils.ValidatorUtil;

import java.util.HashMap;

public class LoginPresenter extends IRegActivity.regpresenter {


    private LoginModel loginModel;
    private IRegActivity.IloginView iloginView;
    private IRegActivity.IregView iregView;

    /**
     * 初始化数据
     * @param
     */

    public LoginPresenter(IRegActivity.IregView iregView){
        loginModel = new LoginModel();
        this.iregView = iregView;

    }
    public LoginPresenter(IRegActivity.IloginView iloginView){
        loginModel = new LoginModel();
        this.iloginView = iloginView;
    }

    public void login(HashMap<String,String> params) {

        String mobile = params.get("mobile");
        if (!ValidatorUtil.isMobile(mobile)){
            if (iloginView!=null){
                iloginView.mobileError("请输入合法手机号");
            }
            return;
        }

        loginModel.login(params, new IRegActivity.RequestCallback() {
            @Override
            public void failure(String msg) {
                iloginView.failure(msg);
            }

            @Override
            public void successMsg(String msg) {
                iloginView.success(msg);
            }

            @Override
            public void success(Object userEntity) {
                iloginView.success((UserEntity) userEntity);
            }
        });


    }

    @Override
    public void register(HashMap<String, String> params) {

        String mobile = params.get("mobile");
        if (!ValidatorUtil.isMobile(mobile)){
            if (iregView!=null){
                iregView.mobileError("请输入合法手机号");
            }
            return;
        }
        loginModel.reg(params, new IRegActivity.RequestCallback() {
            @Override
            public void failure(String msg) {
                iregView.failure(msg);
            }

            @Override
            public void successMsg(String msg) {
                iregView.success(msg);
            }

            @Override
            public void success(Object userEntity) {
                iregView.success((Userreg) userEntity);
            }
        });



    }
}
