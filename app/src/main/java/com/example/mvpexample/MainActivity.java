package com.example.mvpexample;

import android.view.View;

import com.bumptech.glide.Glide;
import com.example.mvpexample.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<MainPresenter, ActivityMainBinding> implements MainView {

    @Override
    protected MainPresenter loadPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void initView() {
        presenter.getBingImage();
    }

    @Override
    public View initViewBinding() {
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        return viewBinding.getRoot();
    }

    @Override
    public void onSuccess(String url) {
        Glide.with(this).load(MainModel.BASE_URL + url.substring(1)).into(viewBinding.bingImage);
    }

}