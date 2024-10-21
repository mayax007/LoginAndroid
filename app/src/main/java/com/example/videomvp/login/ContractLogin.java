package com.example.videomvp.login;

import com.example.videomvp.beans.User;

public interface ContractLogin {
    interface View{

        void successLogin(String message);

        void failureLogin(String err);
    }
    interface Presenter{
        void login(User user);
    }
    interface Model{
        interface OnLoginListener{

            void onFinished(String message);

            void onFailure(String err);
        }
        void loginAPI(User user,
                      OnLoginListener onLoginListener);
    }
}
