package com.xception.schoolevents.core.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    public static EventsService getEventsService() {
        Retrofit retrofit = getRestClient();
        return retrofit.create(EventsService.class);
    }

    private static Retrofit getRestClient() {
        return new Retrofit.Builder()
                .baseUrl(" http://res.cloudinary.com/nomadeducation/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
