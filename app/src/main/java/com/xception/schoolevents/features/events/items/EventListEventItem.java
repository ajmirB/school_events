package com.xception.schoolevents.features.events.items;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.bumptech.glide.Glide;
import com.xception.schoolevents.R;
import com.xception.schoolevents.features.events.contracts.EventListContract;

import butterknife.BindView;
import butterknife.ButterKnife;

@EpoxyModelClass(layout = R.layout.item_event_list_event)
public abstract class EventListEventItem extends EpoxyModelWithHolder<EventListEventItem.Holder> {

    @EpoxyAttribute
    EventListContract.EventItemData eventItemData;

    @Override
    public void bind(@NonNull Holder holder) {
        super.bind(holder);
        holder.dateTextView.setText(eventItemData.dateToDisplay);
        holder.titleTextView.setText(eventItemData.title);
        holder.descriptionTextView.setText(eventItemData.excerpt);
        holder.itemView.setOnClickListener(eventItemData.clickListener);

        if (eventItemData.imageUrl != null) {
            Glide.with(holder.imageView)
                    .load(eventItemData.imageUrl)
                    .into(holder.imageView);
        }
    }

    static class Holder extends EpoxyHolder {

        View itemView;

        @BindView(R.id.event_list_item_image_view)
        ImageView imageView;

        @BindView(R.id.event_list_item_date_text_view)
        TextView dateTextView;

        @BindView(R.id.event_list_item_title_text_view)
        TextView titleTextView;

        @BindView(R.id.event_list_item_description_text_view)
        TextView descriptionTextView;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }
    }
}
