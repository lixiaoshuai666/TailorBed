package com.example.lishuai.modedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * 工单列表页
 */
public class MyListActivity extends Activity {
    private Context myContext;
    private String loginNumber;
    private LinearLayout llCloth;
    private ImageView ivCheck1, ivCheck2;
    private TextView tvNumberItem1, tvNumberItem2, tvClothNumber, tvQr, tvSend;
    private boolean isCheck1, isCheck2;
    private MyNewDialog myNewDialog;
    private ArrayList<String> selectStirng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        myContext = this;
        Intent intent = getIntent();
        loginNumber = intent.getStringExtra("loginNumber");
        initView();
    }

    private void initView() {
        myNewDialog = new MyNewDialog();

    }


}
