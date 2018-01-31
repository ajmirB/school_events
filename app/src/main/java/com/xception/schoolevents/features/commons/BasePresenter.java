package com.xception.schoolevents.features.commons;

public abstract class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter {

    protected T mView;

    public BasePresenter(T view) {
        mView = view;
    }

    @Override
    public void onViewCreated() {

    }

    @Override
    public void onViewDestroyed() {

    }
}
