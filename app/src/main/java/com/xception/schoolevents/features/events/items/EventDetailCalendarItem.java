package com.xception.schoolevents.features.events.items;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.xception.schoolevents.R;

import butterknife.BindView;
import butterknife.ButterKnife;

@EpoxyModelClass(layout = R.layout.item_event_detail_calendar)
public abstract class EventDetailCalendarItem extends EpoxyModelWithHolder<EventDetailCalendarItem.Holder> {

    @EpoxyAttribute
    View.OnClickListener clickListener;

    @Override
    public void bind(@NonNull Holder holder) {
        super.bind(holder);
        holder.button.setOnClickListener(clickListener);
    }

    static class Holder extends EpoxyHolder {

        @BindView(R.id.event_detail_calendar_item_button)
        Button button;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
