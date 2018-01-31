package com.xception.schoolevents.features.events;

import android.support.annotation.NonNull;

import com.xception.schoolevents.features.commons.BaseContract;

import java.util.List;

public interface EventListContract {

    interface Presenter extends BaseContract.Presenter {
    }

    interface View extends BaseContract.View {
        void showItems(@NonNull Data data);
        void goToEventDetail();
    }

    class Data {
        public List<ItemData> itemsData;
    }

    class ItemData {
        public long id;
        public String title;
        public String imageUrl;
        public String date;
        public String title;
        public String excerpt;
        public android.view.View.OnClickListener clickListener;
    }
}
