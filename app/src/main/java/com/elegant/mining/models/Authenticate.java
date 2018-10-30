package com.elegant.mining.models;

import com.google.gson.annotations.SerializedName;

public class Authenticate {
    @SerializedName("userNameOrEmailAddress")
    private String userNameOrEmailAddress;

    @SerializedName("password")
    private String password;

    @SerializedName("rememberClient")
    private boolean rememberClient;

    public String getUserNameOrEmailAddress() {
        return userNameOrEmailAddress;
    }

    public void setUserNameOrEmailAddress(String userNameOrEmailAddress) {
        this.userNameOrEmailAddress = userNameOrEmailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberClient() {
        return rememberClient;
    }

    public void setRememberClient(boolean rememberClient) {
        this.rememberClient = rememberClient;
    }
}
