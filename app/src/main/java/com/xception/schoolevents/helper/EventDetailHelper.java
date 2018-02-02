package com.xception.schoolevents.helper;

import android.content.Context;
import android.text.Html;
import android.text.format.DateFormat;

import com.xception.schoolevents.R;
import com.xception.schoolevents.core.models.events.Event;
import com.xception.schoolevents.features.events.contracts.EventDetailContract;

import java.util.Date;

public class EventDetailHelper {

    /**
     * Create a event item data from an event
     * @param context context to access the date format
     * @param event an event to create the data
     * @return an event data
     */
    public static EventDetailContract.EventData getEventData(Context context, Event event) {
        EventDetailContract.EventData eventData= new EventDetailContract.EventData();

        eventData.address = event.getAddress().getStreetAddress() + " - " + event.getAddress().getCityName();
        eventData.content = Html.fromHtml(event.getContent());

        String dateFormat = context.getString(R.string.event_detail_item_date_pattern);
        Date date = DateHelper.getDate(event.getDateStart());
        eventData.dateToDisplay = (String) DateFormat.format(dateFormat, date);

        return eventData;
    }

    /**
     * Create a calendar item data from an event
     * @param event an event to create the data
     * @return a calendar data
     */
    public static EventDetailContract.CalendarData getCalendarData(Event event) {
        EventDetailContract.CalendarData calendarData = new EventDetailContract.CalendarData();

        calendarData.title = event.getTitle();
        calendarData.date = DateHelper.getDate(event.getDateStart());

        return calendarData;
    }
}
