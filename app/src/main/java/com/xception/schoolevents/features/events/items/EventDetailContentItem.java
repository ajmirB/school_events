package com.xception.schoolevents.features.events.items;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.xception.schoolevents.R;
import com.xception.schoolevents.features.events.contracts.EventDetailContract;

import butterknife.BindView;
import butterknife.ButterKnife;

@EpoxyModelClass(layout = R.layout.item_event_detail_content)
public abstract class EventDetailContentItem extends EpoxyModelWithHolder<EventDetailContentItem.Holder> {

    @EpoxyAttribute
    EventDetailContract.EventData eventData;

    @Override
    public void bind(@NonNull Holder holder) {
        super.bind(holder);
        holder.dateTextView.setText(eventData.dateToDisplay);
        holder.addressTextView.setText(eventData.address);
        holder.contentTextView.setText(eventData.content);
    }

    static class Holder extends EpoxyHolder {

        View itemView;

        @BindView(R.id.event_detail_content_item_address)
        TextView addressTextView;

        @BindView(R.id.event_detail_content_item_date)
        TextView dateTextView;

        @BindView(R.id.event_detail_content_item_content)
        TextView contentTextView;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }
    }
}
