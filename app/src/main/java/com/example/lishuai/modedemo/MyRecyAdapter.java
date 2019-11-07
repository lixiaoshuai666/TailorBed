package com.example.lishuai.modedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lishuai on 2018/11/1.
 */

public class MyRecyAdapter extends RecyclerView.Adapter {
    private Context myContext;
    private ArrayList<String> myList;

    public MyRecyAdapter(Context context, ArrayList<String> list) {
        myContext = context;
        myList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_demo, parent, false);
        return new MyViewHoder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHoder myHolder = (MyViewHoder) holder;
        myHolder.tvTitle.setText("Title" + position);
        myHolder.tvLeft.setText("Left" + position);
        myHolder.tvRight.setText("Right" + position);
//        if (position == myList.size() - 1) {
//            myHolder.viewLine.setVisibility(View.GONE);
//        }
        myHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.sendImage("Title", position);
            }
        });
        myHolder.tvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.sendImage("Left", position);
            }
        });
        myHolder.tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.sendImage("Right", position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHoder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvLeft, tvRight;
        private View viewLine;

        public MyViewHoder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_text);
            tvLeft = itemView.findViewById(R.id.id_left);
            tvRight = itemView.findViewById(R.id.id_right);
            viewLine = itemView.findViewById(R.id.view_line);

        }
    }

    private SetLiendent mlistener;

    public void setListener(SetLiendent listener) {
        this.mlistener = listener;
    }
}
