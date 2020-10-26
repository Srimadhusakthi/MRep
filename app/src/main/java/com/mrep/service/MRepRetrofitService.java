package com.mrep.service;

import com.mrep.common.Common;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MRepRetrofitService {

    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(Common.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build();

    public static <S> S cteateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
