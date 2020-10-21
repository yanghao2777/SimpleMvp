package com.haohao277dev.mvpbase;

public class AbsMvpPresenter<V extends BaseView> {
    public V mvpView;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    public void detachView() {
        this.mvpView = null;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }
}
