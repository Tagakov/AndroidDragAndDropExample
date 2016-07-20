package ru.rma.androiddraganddropexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> implements ItemTouchHelperAdapter {


    private List<ItemModel> mItems;

    public ItemAdapter(@NonNull List<ItemModel> items) {
        mItems = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case R.id.item_type_1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type_1, parent, false);
                break;
            case R.id.item_type_2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type_2, parent, false);
                break;
            case R.id.item_type_3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type_3, parent, false);
                break;
            case R.id.item_type_4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type_4, parent, false);
                break;
            case R.id.item_type_5:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type_5, parent, false);
                break;
            case R.id.item_type_6:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type_6, parent, false);
                break;
            case R.id.item_type_7:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type_7, parent, false);
                break;
            case R.id.item_type_8:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type_8, parent, false);
                break;
            case R.id.item_type_9:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type_9, parent, false);
                break;
            case R.id.item_type_10:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_type_10, parent, false);
                break;
            default:
                throw new RuntimeException("Unknow view type: " + viewType);
        }
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.setName(mItems.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getType();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }
}


class ItemViewHolder extends RecyclerView.ViewHolder {


    private TextView mName;

    public ItemViewHolder(View itemView) {
        super(itemView);

        mName = (TextView) itemView.findViewById(R.id.tv_name);
    }


    public void setName(String name) {
        mName.setText(name);
    }
}
