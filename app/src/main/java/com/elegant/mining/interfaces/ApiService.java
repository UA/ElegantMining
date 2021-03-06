package com.elegant.mining.interfaces;

import com.elegant.mining.models.Authenticate;
import com.elegant.mining.models.AuthenticateResponseResult;
import com.elegant.mining.models.SessionResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/api/TokenAuth/Authenticate")
    Call<AuthenticateResponseResult> authenticate(@Body Authenticate authenticate);
    @GET("/api/services/app/Session/GetCurrentLoginInformations")
    Call<SessionResponse> getCurrentLoginInformations();

}
