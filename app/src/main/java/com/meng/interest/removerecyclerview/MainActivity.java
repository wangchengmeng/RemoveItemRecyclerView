package com.meng.interest.removerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Adapter.IonSlidingViewClickListener {

    private RecyclerView mRecyclerView;

    private Adapter mAdapter;

    private final String TAG = "test";
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setAdapter();

    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        if (null == mDatas) {
            mDatas = new ArrayList<>();
        }
        for (int i = 0; i < 40; i++) {
            mDatas.add(i + "");
        }
    }

    private void setAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new Adapter(this, mDatas));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG, "点击" + position);
    }

    @Override
    public void onDeleteBtnCilck(View view, int position) {
        Log.i(TAG, "删除了" + position);
        mAdapter.removeData(position);
    }
}
