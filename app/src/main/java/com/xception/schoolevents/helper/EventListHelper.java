package com.xception.schoolevents.helper;

import android.content.Context;
import android.text.format.DateFormat;

import com.xception.schoolevents.R;
import com.xception.schoolevents.core.models.events.Event;
import com.xception.schoolevents.features.events.EventListContract;

import java.util.Date;

public class EventListHelper {

    /**
     * Create a section item data from a date
     * @param context context to access the pattern of the title
     * @param date date to create the section
     * @return a section item data which display the date
     */
    public static EventListContract.SectionItemData getSectionItemData(Context context, Date date) {
        EventListContract.SectionItemData sectionItemData= new EventListContract.SectionItemData();

        String titlePattern = context.getString(R.string.event_list_section_item_title_pattern);
        sectionItemData.id = (String) DateFormat.format(titlePattern, date);
        sectionItemData.title = sectionItemData.id;

        return sectionItemData;
    }

    /**
     * Create an event item data from an event server model
     * @param context context to access the pattern of the title
     * @param event event to create the section
     * @return an event item data converted from the event in input
     */
    public static EventListContract.EventItemData getEventItemData(Context context, Event event) {
        EventListContract.EventItemData eventItemData = new EventListContract.EventItemData();

        eventItemData.id = event.getId();
        eventItemData.title = event.getTitle();
        eventItemData.excerpt = event.getExcerpt();

        if (event.getMedias() != null && event.getMedias().size() > 0) {
            eventItemData.imageUrl = event.getMedias().get(0).getUrl();
        }

        eventItemData.date = DateHelper.getDate(event.getDateStart());
        eventItemData.dateToDisplay = getEventItemDateToDisplay(context, eventItemData.date);

        return eventItemData;
    }

    /**
     * Get an event item date to display from a date
     * @param context context to access the pattern of the date to display
     * @param date date to convert to string
     * @return a date to display in an event item
     */
    public static String getEventItemDateToDisplay(Context context, Date date) {
        String titlePattern = context.getString(R.string.event_list_event_item_date_pattern);
        return (String) DateFormat.format(titlePattern,   date);
    }
}
