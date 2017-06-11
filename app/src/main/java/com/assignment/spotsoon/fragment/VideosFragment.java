package com.assignment.spotsoon.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignment.spotsoon.R;
import com.assignment.spotsoon.adapter.ItemClickListener;
import com.assignment.spotsoon.adapter.VideosRecyclerAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class VideosFragment extends Fragment implements ItemClickListener, View.OnClickListener {
    @InjectView(R.id.recyclerViewVideoShow)
    RecyclerView recyclerViewShow;
    private String strName, strType, strKeyWords;
    VideosRecyclerAdapter adapter;
    private ArrayList<String> arrayListAdd = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayListAdd.clear();
        addData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.video_fragment, container, false);
        ButterKnife.inject(this, layout);
        recyclerViewShow.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewShow.setLayoutManager(linearLayoutManager);
        adapter = new VideosRecyclerAdapter(getActivity(), arrayListAdd);
        recyclerViewShow.setAdapter(adapter);
        adapter.setClickListener(this);
        return layout;
    }

    private void addData() {
        arrayListAdd.add("I AM FALLING LOVE WITH YOU ");
        arrayListAdd.add("I HATE YOU WANT BRAKUP ");
        arrayListAdd.add("I AM FALLING LOVE WITH YOU");
        arrayListAdd.add("I HATE YOU WANT BRAKUP ");
        arrayListAdd.add("I AM FALLING LOVE WITH YOU");
        arrayListAdd.add("I HATE YOU WANT BRAKUP ");
    }

    @Override
    public void onClick(View view) {

    }

    public void onClick(View view, int position) {
        switch (view.getId()) {

        }
    }
}
