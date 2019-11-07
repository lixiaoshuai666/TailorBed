package com.example.lishuai.modedemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Author ：Tom
 * Date ：2015/9/27 00:56
 */
public class MyNewDialog {

    /**
     * 显示选择的弹框
     *
     * @param mContext
     * @param list
     * @param dialotListene
     */
    public void showListDialog(Context mContext, final ArrayList<String> list, final DialotListViewListene dialotListene) {
        final Dialog dialog = new Dialog(mContext, R.style.MyLoadingDialogStyle);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_botmon_select, null);
        TextView tvCancel = mView.findViewById(R.id.dialog_web_escs);
        ListView listView = mView.findViewById(R.id.list_view);
        listView.setAdapter(new DialotBotmonAdapter(mContext, list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialotListene.listViewListen(position, list.get(position));
                dialog.dismiss();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setContentView(mView);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();

    }
    public interface DialotListViewListene {
        void listViewListen(int position, String content);
    }

}
