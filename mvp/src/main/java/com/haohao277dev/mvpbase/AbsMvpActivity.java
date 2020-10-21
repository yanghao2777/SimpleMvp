package com.haohao277dev.mvpbase;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public abstract class AbsMvpActivity<P extends AbsMvpPresenter,VB>
        extends AppCompatActivity implements BaseView {


    protected VB viewBinding;
    protected P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(initViewBinding());
        presenter = loadPresenter();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null)
            presenter.detachView();
    }

    protected abstract P loadPresenter();

    public abstract void initView();

    public abstract View initViewBinding();

}
