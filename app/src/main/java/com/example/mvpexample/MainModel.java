package com.example.mvpexample;

import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainModel {

    private LoginService request;
    public static String BASE_URL = "https://cn.bing.com/";

    public MainModel(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();

        request = retrofit.create(LoginService.class);
    }

    public Call<BingBean> getBingImage(String format,int num) {
        return request.getBingImage(format,num);
    }

    public interface LoginService {
        @GET("HPImageArchive.aspx")
        Call<BingBean> getBingImage(@Query("format") String format,
                                    @Query("n") int n);
    }
}
