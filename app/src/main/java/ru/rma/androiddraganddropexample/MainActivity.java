package ru.rma.androiddraganddropexample;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        int id = view != null ? view.getId() : 0;
        switch (id) {
            case R.id.btn_linear:
                startRecyclerViewActivity(RecyclerViewActivity.LAYOUT_MANAGER_LINEAR, false);
                break;
            case R.id.btn_linearDiff:
                startRecyclerViewActivity(RecyclerViewActivity.LAYOUT_MANAGER_LINEAR, true);
                break;
            case R.id.btn_grid:
                startRecyclerViewActivity(RecyclerViewActivity.LAYOUT_MANAGER_GRID, false);
                break;
            case R.id.btn_gridDiff:
                startRecyclerViewActivity(RecyclerViewActivity.LAYOUT_MANAGER_GRID, true);
                break;
            case R.id.btn_staggeredGrid:
                startRecyclerViewActivity(RecyclerViewActivity.LAYOUT_MANAGER_STAGGERED_GRID, false);
                break;
            case R.id.btn_staggeredGridDiff:
                startRecyclerViewActivity(RecyclerViewActivity.LAYOUT_MANAGER_STAGGERED_GRID, true);
                break;
            case R.id.btn_linearPositionDependentTypes:
                startRecyclerViewActivity(RecyclerViewActivity.LAYOUT_MANAGER_LINEAR, true, true);
                break;
        }
    }


    private void startRecyclerViewActivity(int layoutManagerType, boolean diffViewTypes) {
        startRecyclerViewActivity(layoutManagerType, diffViewTypes, false);
    }

    private void startRecyclerViewActivity(int layoutManagerType, boolean diffViewTypes,
                                           boolean typesPosDependent) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        intent.putExtra(RecyclerViewActivity.KEY_LAYOUT_MANAGER_TYPE, layoutManagerType);
        intent.putExtra(RecyclerViewActivity.KEY_DIFFERENT_VIEW_TYPES, diffViewTypes);
        intent.putExtra(RecyclerViewActivity.KEY_TYPES_POS_DEPENDENT, typesPosDependent);
        ActivityCompat.startActivity(this, intent, null);
    }
}
