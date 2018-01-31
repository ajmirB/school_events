package com.xception.schoolevents.features.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xception.schoolevents.R;
import com.xception.schoolevents.features.commons.BaseFragment;

import butterknife.BindView;


public class EventListFragment extends BaseFragment implements EventListContract.View {

    @BindView(R.id.event_list_recycler_view)
    RecyclerView mRecyclerView;

    private EventListContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  super.onCreateView(inflater, container, savedInstanceState);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

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
    public void showItems(EventListContract.Data data) {
        // TODO: display the items in the recycler view
    }

    @Override
    public void goToEventDetail() {
        // TODO open the event detail
    }

    // endregion

    // region companion object

    public static EventListFragment newInstance() {
        EventListFragment fragment = new EventListFragment();
        return fragment;
    }

    // endregion
}
