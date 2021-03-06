package com.xception.schoolevents.features.events.activities;

import android.os.Bundle;

import com.xception.schoolevents.R;
import com.xception.schoolevents.features.commons.BaseActivity;
import com.xception.schoolevents.features.events.fragments.EventListFragment;

public class EventListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        showEventListFragment();
    }

    private void showEventListFragment() {
        EventListFragment fragment = EventListFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_container, fragment)
                .commit();
    }
}
