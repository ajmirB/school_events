package com.xception.schoolevents.features.events;

import com.xception.schoolevents.features.commons.BasePresenter;

import java.util.ArrayList;

public class EventListPresenter extends BasePresenter<EventListContract.View> implements EventListContract.Presenter {

    public EventListPresenter(EventListContract.View view) {
        super(view);
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();

        // TODO: Use data from ws
        // Generate dummy data
        int nbItems = 20;
        EventListContract.Data data = new EventListContract.Data();
        data.itemsData = new ArrayList<>(nbItems);

        EventListContract.SectionItemData sectionItemData;
        EventListContract.EventItemData eventItemData;
        for (int i = 0; i < nbItems; i++){
            if (i == 0 || i%3 == 0) {
                sectionItemData = new EventListContract.SectionItemData();
                sectionItemData.id = i;
                sectionItemData.title = "Month " + i;
                data.itemsData.add(sectionItemData);
            } else {
                eventItemData = new EventListContract.EventItemData();
                eventItemData.id = i;
                eventItemData.date = i + "" + i + "/" + i + "" + i;
                eventItemData.title = "Title " + i;
                eventItemData.excerpt = "Excerpt " + i;
                data.itemsData.add(eventItemData);
            }
        }

        mView.showItems(data);
    }
}
