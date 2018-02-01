package com.xception.schoolevents.features.events.presenters;

import com.xception.schoolevents.core.models.events.Event;
import com.xception.schoolevents.features.commons.BasePresenter;
import com.xception.schoolevents.features.events.contracts.EventDetailContract;
import com.xception.schoolevents.helper.DateHelper;

public class EventDetailPresenter extends BasePresenter<EventDetailContract.View> implements EventDetailContract.Presenter {


    public EventDetailPresenter(EventDetailContract.View view, Event event) {
        super(view);

        // Create the data to display in the view
        EventDetailContract.Data data = new EventDetailContract.Data();
        data.title = event.getTitle();

        data.eventData = new EventDetailContract.EventData();
        data.eventData.address = event.getAddress().getStreetAddress() + " - " + event.getAddress().getCityName();
        data.eventData.content = event.getContent();
        data.eventData.dateToDisplay = event.getDateStart();

        EventDetailContract.CalendarData calendarData = new EventDetailContract.CalendarData();
        calendarData.title = event.getTitle();
        calendarData.date = DateHelper.getDate(event.getDateStart());
        data.calendarClickListener = v -> mView.goToCalendar(calendarData);

        // Display the data
        mView.showEvent(data);
    }

}
