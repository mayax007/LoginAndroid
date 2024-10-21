package com.example.videomvp.login.model;

import android.util.Log;

import com.example.videomvp.beans.User;
import com.example.videomvp.login.ContractLogin;
import com.example.videomvp.login.presenter.LoginPresenter;
import com.example.videomvp.utils.ApiResponse;
import com.example.videomvp.utils.ApiService;
import com.example.videomvp.utils.RetrofitClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements ContractLogin.Model {
    private static final String IP_BASE = "10.0.2.2:8080";

    private LoginPresenter presenter;
    public LoginModel(LoginPresenter presenter){
        this.presenter = presenter;
    }


    @Override
    public void loginAPI(User user, final OnLoginListener onLoginListener) {
        ApiService apiService = RetrofitClient.getClient("http://" + IP_BASE + "/").
                create(ApiService.class);

        // Fetch
        Call<ApiResponse> call = apiService.login (user.getEmail(),user.getPassword());
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse myData = response.body();

                    String message = myData.getMessage();

                    onLoginListener.onFinished(message);
                } else {
                    Log.e("Response Error", "Código de estado HTTP: " + response.code());
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("Response Error", "Cuerpo de error: " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }
}