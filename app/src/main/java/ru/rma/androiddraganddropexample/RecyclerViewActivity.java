package ru.rma.androiddraganddropexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewActivity extends AppCompatActivity {

    public static final String KEY_DIFFERENT_VIEW_TYPES = "ru.rma.androiddraganddropexample.RecyclerViewActivity.KEY_DIFFERENT_VIEW_TYPES";
    public static final String KEY_LAYOUT_MANAGER_TYPE = "ru.rma.androiddraganddropexample.RecyclerViewActivity.KEY_LAYOUT_MANAGER_TYPE";
    public static final int LAYOUT_MANAGER_LINEAR = 1;
    public static final int LAYOUT_MANAGER_GRID = 2;
    public static final int LAYOUT_MANAGER_STAGGERED_GRID = 3;

    public static final int SPAN_COUNT = 2;
    public static final int ITEM_COUNT = 20;


    private int mLayoutManagerType;
    private boolean isDifferentViewTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        if (savedInstanceState != null) {
            isDifferentViewTypes = savedInstanceState.getBoolean(KEY_DIFFERENT_VIEW_TYPES, true);
            mLayoutManagerType = savedInstanceState.getInt(KEY_LAYOUT_MANAGER_TYPE, LAYOUT_MANAGER_LINEAR);
        } else if (intent != null) {
            isDifferentViewTypes = intent.getBooleanExtra(KEY_DIFFERENT_VIEW_TYPES, true);
            mLayoutManagerType = intent.getIntExtra(KEY_LAYOUT_MANAGER_TYPE, LAYOUT_MANAGER_LINEAR);
        } else {
            isDifferentViewTypes = true;
            mLayoutManagerType = LAYOUT_MANAGER_LINEAR;
        }

        ItemAdapter adapter = new ItemAdapter(createItemList());
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_list);
        switch (mLayoutManagerType) {
            case LAYOUT_MANAGER_GRID:
                rv.setLayoutManager(new GridLayoutManager(this, SPAN_COUNT));
                break;
            case LAYOUT_MANAGER_STAGGERED_GRID:
                rv.setLayoutManager(new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL));
                break;
            case LAYOUT_MANAGER_LINEAR:
            default:
                rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                break;
        }
        rv.setAdapter(adapter);

        ItemTouchHelper ith = new ItemTouchHelper(new ItemTouchHelperCallback(adapter));
        ith.attachToRecyclerView(rv);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_LAYOUT_MANAGER_TYPE, mLayoutManagerType);
    }


    private List<ItemModel> createItemList() {
        List<ItemModel> list = new ArrayList<>();

        if (isDifferentViewTypes) {
            list.add(new ItemModel(R.id.item_type_1, "1"));
            list.add(new ItemModel(R.id.item_type_2, "2"));
            list.add(new ItemModel(R.id.item_type_3, "3"));
            list.add(new ItemModel(R.id.item_type_4, "4"));
            list.add(new ItemModel(R.id.item_type_5, "5"));
            list.add(new ItemModel(R.id.item_type_6, "6"));
            list.add(new ItemModel(R.id.item_type_7, "7"));
            list.add(new ItemModel(R.id.item_type_8, "8"));
            list.add(new ItemModel(R.id.item_type_9, "9"));
            list.add(new ItemModel(R.id.item_type_10, "10"));
            list.add(new ItemModel(R.id.item_type_1, "11"));
            list.add(new ItemModel(R.id.item_type_2, "12"));
            list.add(new ItemModel(R.id.item_type_3, "13"));
            list.add(new ItemModel(R.id.item_type_4, "14"));
            list.add(new ItemModel(R.id.item_type_5, "15"));
            list.add(new ItemModel(R.id.item_type_6, "16"));
            list.add(new ItemModel(R.id.item_type_7, "17"));
            list.add(new ItemModel(R.id.item_type_8, "18"));
            list.add(new ItemModel(R.id.item_type_9, "19"));
            list.add(new ItemModel(R.id.item_type_10, "20"));
        } else {
            for (int i = 0; i < ITEM_COUNT; ++i) {
                list.add(new ItemModel(R.id.item_type_1, String.valueOf(i)));
            }
        }

        return list;
    }
}
