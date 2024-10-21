package com.example.videomvp.utils;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    public static final String URL ="http://10.0.2.2:8080";
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    @POST("/login")
    Call<ApiResponse> login(@Query("correo") String email,
                            @Query("contrasena") String password);

}
