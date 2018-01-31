package com.xception.schoolevents.features.events;

import com.xception.schoolevents.features.commons.BaseContract;

import java.util.List;

public interface EventListContract {

    interface Presenter extends BaseContract.Presenter {
    }

    interface View extends BaseContract.View {
        void showItems(Data data);
        void goToEventDetail();
    }

    class Data {
        public List<ItemData> itemData;
    }

    class ItemData {
        public String imageUrl;
        public String date;
        public String title;
        public String excerpt;
        public android.view.View.OnClickListener clickListener;
    }
}
