package com.elegant.mining.models;

import com.google.gson.annotations.SerializedName;

public class AuthenticateResponse {



    @SerializedName("accessToken")
    private String accessToken;

    @SerializedName("encryptedAccessToken")
    private String encryptedAccessToken;

    @SerializedName("expireInSeconds")
    private int expireInSeconds;

    @SerializedName("userId")
    private int userId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getEncryptedAccessToken() {
        return encryptedAccessToken;
    }

    public void setEncryptedAccessToken(String encryptedAccessToken) {
        this.encryptedAccessToken = encryptedAccessToken;
    }

    public int getExpireInSeconds() {
        return expireInSeconds;
    }

    public void setExpireInSeconds(int expireInSeconds) {
        this.expireInSeconds = expireInSeconds;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
