package ru.rma.androiddraganddropexample;

import android.support.annotation.NonNull;

import java.util.List;

public class PositionTypeAdapter extends ItemAdapter {
    public PositionTypeAdapter(@NonNull List<ItemModel> items) {
        super(items);
    }

    public int getItemViewTypeByPos(int position) {
        if(position == 0) {
            return R.id.item_type_1;
        } else if(position == getItemCount() - 1) {
            return R.id.item_type_2;
        } else {
            return R.id.item_type_3;
        }
    }

    @Override
    public void rebindViewTypes() {
        for (int i = 0; i < mItems.size(); i++) {
            ItemModel mItem = mItems.get(i);
            int newVT = getItemViewTypeByPos(i);
            if (mItem.getType() != newVT) {
                mItem.setType(newVT);
                notifyItemChanged(i);
            }
        }
    }
}
