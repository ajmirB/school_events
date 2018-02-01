package com.xception.schoolevents.features.commons.items;

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

import static com.airbnb.epoxy.EpoxyAttribute.Option.DoNotHash;

@EpoxyModelClass(layout = R.layout.item_fallback)
public abstract class FallbackItem extends EpoxyModelWithHolder<FallbackItem.Holder> {

    @EpoxyAttribute(DoNotHash)
    View.OnClickListener clickListener;
    
    @Override
    public void bind(@NonNull Holder holder) {
        super.bind(holder);
        holder.button.setOnClickListener(clickListener);
    }

    static class Holder extends EpoxyHolder {

        View itemView;
        
        @BindView(R.id.fallback_item_button)
        Button button;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }
    }
    
}
