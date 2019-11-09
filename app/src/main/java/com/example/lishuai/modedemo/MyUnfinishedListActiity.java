package com.example.lishuai.modedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MyUnfinishedListActiity extends Activity {

    private Context myContext;
    private String loginNumber;
    private MyNewDialog myNewDialog;
    private RecyclerView recyView;
    private ArrayList<String> strList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_unfinished_list);
        myContext = this;
        Intent intent = getIntent();
        loginNumber = intent.getStringExtra("loginNumber");
        initView();
    }

    private void initView() {
        RecyclerView recyView = findViewById(R.id.recy_view);
        strList = new ArrayList<>();
        strList.add("");
        strList.add("");
        strList.add("");
        strList.add("");
        strList.add("");
        strList.add("");
        CareerSelectClientAdapter myAdapter = new CareerSelectClientAdapter(strList, myContext, recyView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyView.setLayoutManager(linearLayoutManager);
        recyView.setAdapter(myAdapter);

    }
}
