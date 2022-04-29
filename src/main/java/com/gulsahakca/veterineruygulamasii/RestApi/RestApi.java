package com.gulsahakca.veterineruygulamasii.RestApi;

import com.gulsahakca.veterineruygulamasii.Models.RegisterPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.POST;

public interface RestApi {

        @FormUrlEncoded
        @POST("/signup.php")
        Call<RegisterPojo> registerUser( @Field("mailaddress") String mailaddress,@Field("username") String username,
                                        @Field("password") String password);
    }

