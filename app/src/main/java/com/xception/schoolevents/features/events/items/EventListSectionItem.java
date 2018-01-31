package com.xception.schoolevents.features.events.items;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.xception.schoolevents.R;
import com.xception.schoolevents.features.events.EventListContract;

import butterknife.BindView;
import butterknife.ButterKnife;

@EpoxyModelClass(layout = R.layout.item_event_list_section)
public abstract class EventListSectionItem extends EpoxyModelWithHolder<EventListSectionItem.Holder> {

    @EpoxyAttribute
    EventListContract.SectionItemData sectionItemData;

    @Override
    public void bind(@NonNull Holder holder) {
        super.bind(holder);
        holder.titleTextView.setText(sectionItemData.title);
    }

    static class Holder extends EpoxyHolder {

        @BindView(R.id.event_list_section_item_text_view)
        TextView titleTextView;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
