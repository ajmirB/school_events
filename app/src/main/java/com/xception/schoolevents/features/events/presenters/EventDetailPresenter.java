package com.xception.schoolevents.features.events.presenters;

import android.content.Context;

import com.xception.schoolevents.core.models.events.Event;
import com.xception.schoolevents.features.commons.BasePresenter;
import com.xception.schoolevents.features.events.contracts.EventDetailContract;
import com.xception.schoolevents.helper.ApplicationHelper;
import com.xception.schoolevents.helper.EventDetailHelper;

public class EventDetailPresenter extends BasePresenter<EventDetailContract.View> implements EventDetailContract.Presenter {


    public EventDetailPresenter(EventDetailContract.View view, Event event) {
        super(view);
        Context context = ApplicationHelper.getInstance().getContext();

        // Create the data to display in the view
        EventDetailContract.Data data = new EventDetailContract.Data();
        data.title = event.getTitle();
        data.eventData = EventDetailHelper.getEventData(context, event);
        data.calendarClickListener = v -> mView.goToCalendar(EventDetailHelper.getCalendarData(event));

        // Display the data
        mView.showEvent(data);
    }

}
