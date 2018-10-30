package com.elegant.mining.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class AuthenticateResponseResult {
    @SerializedName("result")
    private AuthenticateResponse authenticateResponse;
    @SerializedName("targetUrl")
    private Object targetUrl;
    @SerializedName("success")
    private Boolean success;
    @SerializedName("error")
    private Object error;
    @SerializedName("unAuthorizedRequest")
    private Boolean unAuthorizedRequest;
    @SerializedName("__abp")
    private Boolean abp;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public AuthenticateResponse getResult() {
        return authenticateResponse;
    }

    public void setResult(AuthenticateResponse authenticateResponse) {
        this.authenticateResponse = authenticateResponse;
    }

    public Object getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(Object targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Boolean getUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public void setUnAuthorizedRequest(Boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public Boolean getAbp() {
        return abp;
    }

    public void setAbp(Boolean abp) {
        this.abp = abp;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
