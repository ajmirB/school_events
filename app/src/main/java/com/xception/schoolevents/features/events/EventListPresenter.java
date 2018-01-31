package com.xception.schoolevents.features.events;

import com.xception.schoolevents.features.commons.BasePresenter;

public class EventListPresenter extends BasePresenter<EventListContract.View> implements EventListContract.Presenter {

    public EventListPresenter(EventListContract.View view) {
        super(view);
    }
}
