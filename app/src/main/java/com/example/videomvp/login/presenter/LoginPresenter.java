package com.example.videomvp.login.presenter;

import com.example.videomvp.beans.User;
import com.example.videomvp.login.ContractLogin;
import com.example.videomvp.login.model.LoginModel;

public class LoginPresenter implements ContractLogin.Presenter, ContractLogin.Model.OnLoginListener {

    private ContractLogin.View view;
    private ContractLogin.Model model;

    public LoginPresenter(ContractLogin.View view){
        this.view = view;
        model = new LoginModel(this);
    }
    @Override
    public void login(User user) {
        model.loginAPI(user, this);
    }

    @Override
    public void onFinished(String message) {
        view.successLogin(message);
    }

    @Override
    public void onFailure(String err) {

    }
}
