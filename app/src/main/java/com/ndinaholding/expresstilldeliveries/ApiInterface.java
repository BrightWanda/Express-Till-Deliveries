package com.ndinaholding.expresstilldeliveries;

import com.ndinaholding.expresstilldeliveries.POJOs.Clients;
import com.ndinaholding.expresstilldeliveries.POJOs.Login;
import com.ndinaholding.expresstilldeliveries.POJOs.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static android.R.attr.path;

/**
 * Created by wandab on 2017/07/07.
 */
public interface ApiInterface {

    @FormUrlEncoded
    @POST("register")
    Call<Register> sendRegister(
            @Field("email") String email,
            @Field("cellphone") String cellphone,
            @Field("password") String password);
    @FormUrlEncoded
    @POST("login")
    Call<Login> sendLogin(
            @Field("email") String email,
            @Field("password") String password);
    @FormUrlEncoded
    @POST("clients")
    Call<Clients> getClients(@Header("Apikey") String apiKey,
                             @Field("category") int category);
}
