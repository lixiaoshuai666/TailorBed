package com.example.lishuai.modedemo;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * 创建dialog的建造者模式
 * Created by andongwang on 2018/4/16.
 */
public class DialogBuilder {
    public static Dialog getDialog(Context myContext, String title, final DialogListener dialogListen) {
        final Dialog dialog = new Dialog(myContext, R.style.MyLoadDialog);
        View mView = LayoutInflater.from(myContext).inflate(R.layout.dialog_delte_experts, null);
        TextView mEnter = mView.findViewById(R.id.dialog_web_enter);
        final TextView dialogLeft = mView.findViewById(R.id.dialog_left);
        TextView mTitle = mView.findViewById(R.id.edit_content);
        mTitle.setText(title);
        dialog.setContentView(mView);
        dialog.show();
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListen.rightOnclick();
            }
        });
        dialogLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListen.leftOnclick();
            }
        });
        return dialog;
    }

    public interface DialogListener {
        void leftOnclick();

        void rightOnclick();
    }


}
