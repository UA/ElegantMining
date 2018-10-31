package com.elegant.mining.models;

import android.app.Application;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class SessionResponse {
    @SerializedName("application")
    private Application application;
    @SerializedName("user")
    private User user;
    @SerializedName("tenant")
    private Tenant tenant;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
