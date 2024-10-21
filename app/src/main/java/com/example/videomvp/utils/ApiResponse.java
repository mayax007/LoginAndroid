package com.example.videomvp.utils;

import com.example.videomvp.beans.User;

import java.util.ArrayList;

public class ApiResponse {
    private String message;
    private ArrayList<User> lstUsers;


    public String getMessage() {
        return message;
    }
    public ArrayList<User> getLstUsers() {
        return lstUsers;
    }
    public void setLstUsers(ArrayList<User> lstUsers) {
        this.lstUsers = lstUsers;
    }
}
