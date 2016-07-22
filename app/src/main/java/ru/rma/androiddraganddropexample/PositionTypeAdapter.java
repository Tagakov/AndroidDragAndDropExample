package ru.rma.androiddraganddropexample;

import android.support.annotation.NonNull;

import java.util.List;

public class PositionTypeAdapter extends ItemAdapter {
    public PositionTypeAdapter(@NonNull List<ItemModel> items) {
        super(items);
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return R.id.item_type_1;
        } else if(position == getItemCount() - 1) {
            return R.id.item_type_2;
        } else {
            return R.id.item_type_3;
        }
    }
}
