package com.xception.schoolevents.features.events.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.xception.schoolevents.R;
import com.xception.schoolevents.core.models.events.Event;
import com.xception.schoolevents.features.commons.BaseActivity;
import com.xception.schoolevents.features.events.fragments.EventDetailFragment;

import org.parceler.Parcels;

public class EventDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        setNavigationBackButton(true);

        Event event = Parcels.unwrap(getIntent().getParcelableExtra(EVENT_KEY));
        showEventDetailFragment(event);
    }

    private void showEventDetailFragment(Event event) {
        EventDetailFragment fragment = EventDetailFragment.newInstance(event);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_container, fragment)
                .commit();
    }

    // region companion object

    private static String EVENT_KEY = "event_key";

    public static Intent newIntent(Activity activity, Event event) {
        Intent intent = new Intent(activity, EventDetailActivity.class);
        intent.putExtra(EVENT_KEY, Parcels.wrap(event));
        return intent;
    }

    // endregion
}
