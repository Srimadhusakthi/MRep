package com.mrep.doctor.networking.API;

import com.mrep.doctor.model.LoginRequestModel;
import com.mrep.doctor.networking.UrlMaster;
import com.mrep.doctor.networking.interfaces.GenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginAPI {

    @POST(UrlMaster.LOGIN)
    Call<GenResponse<Integer, Object>> login(@Body LoginRequestModel loginRequest);

}
