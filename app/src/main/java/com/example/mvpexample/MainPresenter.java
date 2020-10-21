package com.example.mvpexample;

import com.haohao277dev.mvpbase.AbsMvpPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends AbsMvpPresenter<MainView> {

    private MainModel model;

    public MainPresenter(MainView mvpView){
        this.mvpView = mvpView;
        model = new MainModel();
    }

    public void getBingImage(){
        model.getBingImage("js",1).enqueue(new Callback<BingBean>() {
            @Override
            public void onResponse(Call<BingBean> call, Response<BingBean> response) {
                if(response.isSuccessful() && response.body() != null){
                    mvpView.onSuccess(response.body().getImages().get(0).getUrl());
                }
            }

            @Override
            public void onFailure(Call<BingBean> call, Throwable t) {
                mvpView.onFail();
            }
        });
    }
}
