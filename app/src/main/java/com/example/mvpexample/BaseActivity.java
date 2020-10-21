package com.example.mvpexample;

import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;
import com.haohao277dev.mvpbase.AbsMvpActivity;
import com.haohao277dev.mvpbase.AbsMvpPresenter;
import com.haohao277dev.mvpbase.BaseView;

public abstract class BaseActivity<P extends AbsMvpPresenter,VB>
        extends AbsMvpActivity<P,VB> implements BaseView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO : set status bar
        ImmersionBar.with(this)
                .fitsSystemWindows(true)
                .statusBarColor(R.color.colorPrimaryDark)
                .init();

        initView();
    }

    @Override
    public void onFail() {
        //TODO : Log error in base
    }
}

