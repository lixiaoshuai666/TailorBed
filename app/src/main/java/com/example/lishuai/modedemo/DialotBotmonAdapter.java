package com.example.lishuai.modedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lishuai on 2019/1/2.
 */

public class DialotBotmonAdapter extends BaseAdapter {
    ArrayList<String> myList;
    private LayoutInflater mInflater;

    public DialotBotmonAdapter(Context context, ArrayList<String> list) {
        myList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.item_dialot_botmon, parent, false);
        TextView textEscs = convertView.findViewById(R.id.dialog_web_escs);
        textEscs.setText(myList.get(position));
        return convertView;
    }
}
