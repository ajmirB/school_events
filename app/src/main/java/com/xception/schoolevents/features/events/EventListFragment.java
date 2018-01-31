package com.xception.schoolevents.features.events;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.xception.schoolevents.R;
import com.xception.schoolevents.features.commons.BaseFragment;
import com.xception.schoolevents.features.events.items.EventListEventItem_;
import com.xception.schoolevents.features.events.items.EventListSectionItem_;

import butterknife.BindView;


public class EventListFragment extends BaseFragment implements EventListContract.View {

    @BindView(R.id.event_list_recycler_view)
    EpoxyRecyclerView mRecyclerView;

    private EventListContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  super.onCreateView(inflater, container, savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        mPresenter = new EventListPresenter(this);

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
        return R.layout.fragment_event_list;
    }

    // region  EventListContract.View

    @Override
    public void showItems(@NonNull EventListContract.Data data) {
        mRecyclerView.buildModelsWith(controller -> {
            for (EventListContract.ItemData itemData : data.itemsData) {
                Log.d(TAG, "showItems: " + itemData.id);
                if (itemData instanceof EventListContract.SectionItemData) {
                    new EventListSectionItem_()
                            .id(itemData.id)
                            .sectionItemData((EventListContract.SectionItemData) itemData)
                            .addTo(controller);
                } else if (itemData instanceof EventListContract.EventItemData) {
                    new EventListEventItem_()
                            .id(itemData.id)
                            .eventItemData((EventListContract.EventItemData) itemData)
                            .addTo(controller);
                } else {
                    Log.e(TAG, "showItems: item not recognized");
                }
            }
        });
    }

    @Override
    public void goToEventDetail() {
        // TODO open the event detail
    }

    // endregion

    // region companion object

    public static String TAG = EventListFragment.class.getSimpleName();

    public static EventListFragment newInstance() {
        EventListFragment fragment = new EventListFragment();
        return fragment;
    }

    // endregion
}
