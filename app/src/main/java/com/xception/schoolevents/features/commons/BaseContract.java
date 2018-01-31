package com.xception.schoolevents.features.commons;

public interface BaseContract {

    interface Presenter {
        void onViewCreated();
        void onViewDestroyed();
    }

    interface View {
    }
}
