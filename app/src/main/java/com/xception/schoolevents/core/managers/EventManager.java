package com.xception.schoolevents.core.managers;

import com.xception.schoolevents.core.api.EventsService;
import com.xception.schoolevents.core.api.RestClient;
import com.xception.schoolevents.core.models.events.Event;

import java.util.List;

import io.reactivex.Single;

public class EventManager {

    private EventsService mEventsService;

    public EventManager() {
        mEventsService = RestClient.getEventsService();
    }

    /**
     * @return the list of events from server
     */
    public Single<List<Event>> getEvents() {
        return mEventsService.getEvents().singleOrError();
    }
}
