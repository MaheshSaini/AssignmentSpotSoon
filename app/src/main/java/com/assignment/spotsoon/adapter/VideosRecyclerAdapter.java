package com.assignment.spotsoon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.assignment.spotsoon.R;

import java.util.List;

public class VideosRecyclerAdapter extends RecyclerView.Adapter<VideosRecyclerAdapter.MyViewHolder> {

    private List<String> listItems;
    public Context mContext;
    private ItemClickListener clickListener;
    MyViewHolder viewHolder;

    public VideosRecyclerAdapter(Context context, List<String> listItems) {
        this.listItems = listItems;
        this.mContext = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
        viewHolder = new MyViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder customViewHolder, int position) {

        customViewHolder.txtDisplay.setText(listItems.get(position));
    }

    public void addData(List<String> popularSpecialtiyList) {

        this.listItems = popularSpecialtiyList;
    }

    @Override
    public int getItemCount() {
        return (null != listItems ? listItems.size() : 0);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    // initializes some private fields to be used by RecyclerView.
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtDisplay;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtDisplay = (TextView) itemView.findViewById(R.id.txtTitle);

        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }


}
