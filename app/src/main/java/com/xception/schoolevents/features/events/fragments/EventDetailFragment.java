package com.xception.schoolevents.features.events.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.xception.schoolevents.R;
import com.xception.schoolevents.core.models.events.Event;
import com.xception.schoolevents.features.commons.BaseFragment;
import com.xception.schoolevents.features.events.contracts.EventDetailContract;
import com.xception.schoolevents.features.events.items.EventDetailCalendarItem_;
import com.xception.schoolevents.features.events.items.EventDetailContentItem_;
import com.xception.schoolevents.features.events.presenters.EventDetailPresenter;

import org.parceler.Parcels;

import butterknife.BindView;


public class EventDetailFragment extends BaseFragment implements EventDetailContract.View {

    @BindView(R.id.event_detail_recycler_view)
    EpoxyRecyclerView mRecyclerView;

    private EventDetailContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  super.onCreateView(inflater, container, savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        Event event = Parcels.unwrap(getArguments().getParcelable(EVENT_KEY));
        mPresenter = new EventDetailPresenter(this, event);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.onViewCreated();
    }

    @Override
    public void onDestroyView() {
        mPresenter.onViewDestroyed();
        super.onDestroyView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_event_detail;
    }

    // region  EventDetailContract.View

    @Override
    public void showEvent(@NonNull EventDetailContract.Data data) {
        mRecyclerView.buildModelsWith(controller -> {
            new EventDetailContentItem_()
                    .id(0)
                    .eventData(data.eventData)
                    .addTo(controller);

            new EventDetailCalendarItem_()
                    .id(1)
                    .clickListener(data.calendarClickListener)
                    .addTo(controller);
        });
    }

    @Override
    public void goToCalendar(EventDetailContract.CalendarData calendarData) {
        Toast.makeText(getContext(), "Not implemented", Toast.LENGTH_LONG).show();
    }

    // endregion

    // region companion object

    public static String TAG = EventDetailFragment.class.getSimpleName();

    private static String EVENT_KEY = "event_key";

    public static EventDetailFragment newInstance(Event event) {
        EventDetailFragment fragment = new EventDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(EVENT_KEY, Parcels.wrap(event));
        fragment.setArguments(bundle);

        return fragment;
    }

    // endregion
}
