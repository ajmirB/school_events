package com.xception.schoolevents.features.events.contracts;

import android.support.annotation.NonNull;

import com.xception.schoolevents.features.commons.BaseContract;

import java.util.Date;

import static android.view.View.OnClickListener;

public interface EventDetailContract extends BaseContract {

    interface Presenter extends BaseContract.Presenter {
    }

    interface View extends BaseContract.View {
        void showEvent(@NonNull Data data);
        void goToCalendar(CalendarData calendarData);
    }

    class Data {
        public String title;
        public EventData eventData;
        public OnClickListener calendarClickListener;
    }

    class EventData {
        public String address;
        public String dateToDisplay;
        public String content;
    }

    class CalendarData {
        public String title;
        public Date date;
    }
}
