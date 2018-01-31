package com.xception.schoolevents.core.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface EventsService {

    @GET("raw/upload/v1510821111/events_uqwefr.json")
    Observable<List<Object>> getEvents();
}
