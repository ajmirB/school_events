package com.xception.schoolevents.features.events.contracts;

import android.support.annotation.NonNull;

import com.xception.schoolevents.core.models.events.Event;
import com.xception.schoolevents.features.commons.BaseContract;

import java.util.Date;
import java.util.List;

import static android.view.View.*;

public interface EventListContract extends BaseContract {

    interface Presenter extends BaseContract.Presenter {
    }

    interface View extends BaseContract.View {
        void showItems(@NonNull Data data);
        void showFallback(@NonNull OnClickListener onClickListener);
        void goToEventDetail(@NonNull Event event);
    }

    class Data {
        public List<ItemData> itemsData;
    }

    class ItemData {
        public String id;
        public String title;
    }

    class SectionItemData extends ItemData {
    }

    class EventItemData extends ItemData {
        public String imageUrl;
        public Date date;
        public String dateToDisplay;
        public String excerpt;
        public OnClickListener clickListener;
    }
}
