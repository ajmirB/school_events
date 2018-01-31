package com.xception.schoolevents.features.events.items;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.xception.schoolevents.R;
import com.xception.schoolevents.features.events.EventListContract;

import butterknife.BindView;
import butterknife.ButterKnife;

@EpoxyModelClass(layout = R.layout.item_event_list_event)
public abstract class EventListEventItem extends EpoxyModelWithHolder<EventListEventItem.Holder> {

    @EpoxyAttribute
    EventListContract.EventItemData eventItemData;

    @Override
    public void bind(@NonNull Holder holder) {
        super.bind(holder);
        holder.dateTextView.setText(eventItemData.date);
        holder.titleTextView.setText(eventItemData.title);
        holder.excerptTextView.setText(eventItemData.excerpt);
        holder.itemView.setOnClickListener(eventItemData.clickListener);
    }

    static class Holder extends EpoxyHolder {

        View itemView;

        @BindView(R.id.event_list_item_image_view)
        ImageView imageView;

        @BindView(R.id.event_list_item_date_text_view)
        TextView dateTextView;

        @BindView(R.id.event_list_item_title_text_view)
        TextView titleTextView;

        @BindView(R.id.event_list_item_excerpt_text_view)
        TextView excerptTextView;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }
    }
}
