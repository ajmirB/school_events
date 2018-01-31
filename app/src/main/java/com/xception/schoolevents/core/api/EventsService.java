package com.xception.schoolevents.core.api;

import com.xception.schoolevents.core.models.events.Event;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface EventsService {

    @GET("raw/upload/v1510821111/events_uqwefr.json")
    Observable<List<Event>> getEvents();
}
