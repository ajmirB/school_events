package com.xception.schoolevents.features.events;

import android.content.Context;

import com.xception.schoolevents.core.api.RestClient;
import com.xception.schoolevents.features.commons.BasePresenter;
import com.xception.schoolevents.helper.ApplicationHelper;
import com.xception.schoolevents.helper.DateHelper;
import com.xception.schoolevents.helper.EventListHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class EventListPresenter extends BasePresenter<EventListContract.View> implements EventListContract.Presenter {

    public EventListPresenter(EventListContract.View view) {
        super(view);
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        Context context = ApplicationHelper.getInstance().getContext();

        RestClient.getEventsService().getEvents()
                .subscribeOn(Schedulers.io())
                // Convert each item from server to a data item
                .flatMap(Observable::fromIterable)
                .map(event -> EventListHelper.getEventItemDate(context, event))
                // Merge all item as a sorted list
                .sorted((eventItemData1, eventItemData2) -> eventItemData1.date.compareTo(eventItemData2.date))
                .toList()
                .map(eventItemsData ->  {
                    List<EventListContract.ItemData> itemsData = new ArrayList<>(eventItemsData.size());

                    int monthBefore;
                    int yearBefore;
                    int currentMonth;
                    int currentYear;
                    for (int i=0; i<eventItemsData.size(); i++) {
                        // Create section if necessary
                        if (i == 0) {
                            itemsData.add(EventListHelper.getSectionItemData(context, eventItemsData.get(i).date));
                        } else  {
                            monthBefore = DateHelper.getMonth(eventItemsData.get(i-1).date);
                            yearBefore = DateHelper.getYear(eventItemsData.get(i-1).date);
                            currentMonth = DateHelper.getMonth(eventItemsData.get(i).date);
                            currentYear = DateHelper.getYear(eventItemsData.get(i).date);

                            if (currentYear > yearBefore ||monthBefore < currentMonth) {
                                itemsData.add(EventListHelper.getSectionItemData(context, eventItemsData.get(i).date));
                            }
                        }

                        // Add the current formatted item
                        itemsData.add(eventItemsData.get(i));
                    }

                    return itemsData;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        itemsData -> {
                            // Display the items
                            EventListContract.Data data = new EventListContract.Data();
                            data.itemsData = itemsData;
                            mView.showItems(data);
                        },
                        Throwable::printStackTrace
                );

    }
}
