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
        selectStirng = new ArrayList<>();
        selectStirng.add("XL89788");
        selectStirng.add("AH056");
        selectStirng.add("XL89065");
        tvQr = findViewById(R.id.tv_qr);
        tvSend = findViewById(R.id.tv_send);
        llCloth = findViewById(R.id.ll_cloth);
        llCloth = findViewById(R.id.ll_cloth);
        ivCheck1 = findViewById(R.id.iv_check1);
        ivCheck2 = findViewById(R.id.iv_check2);
        tvNumberItem1 = findViewById(R.id.tv_number_item1);
        tvNumberItem2 = findViewById(R.id.tv_number_item2);
        tvClothNumber = findViewById(R.id.tv_cloth_number);
        ivCheck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(tvClothNumber.getText().toString().trim())) {
                    Toast.makeText(myContext, "请先选择布料编码", Toast.LENGTH_LONG).show();
                    return;
                }
                if (isCheck1) {
                    ivCheck1.setImageResource(R.mipmap.tool_addr_checkbox_normal);
                    isCheck1 = false;
                } else {
                    ivCheck1.setImageResource(R.mipmap.tool_addr_checkbox_checked);
                    isCheck1 = true;
                }
            }
        });
        ivCheck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(tvClothNumber.getText().toString().trim())) {
                    Toast.makeText(myContext, "请先选择布料编码", Toast.LENGTH_LONG).show();
                    return;
                }
                if (isCheck2) {
                    ivCheck2.setImageResource(R.mipmap.tool_addr_checkbox_normal);
                    isCheck2 = false;
                } else {
                    ivCheck2.setImageResource(R.mipmap.tool_addr_checkbox_checked);
                    isCheck2 = true;
                }
            }
        });
        llCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNewDialog.showListDialog(myContext, selectStirng, new MyNewDialog.DialotListViewListene() {
                    @Override
                    public void listViewListen(int position, String content) {
                        tvNumberItem1.setText(content);
                        tvNumberItem2.setText(content);
                        tvClothNumber.setText(content);
                    }
                });
            }
        });
        tvQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(tvClothNumber.getText().toString().trim())) {
                    Toast.makeText(myContext, "请先选择布料编码", Toast.LENGTH_LONG).show();
                    return;
                }
                if (isCheck1 || isCheck2) {

                } else {
                    Toast.makeText(myContext, "请选择要完成的工单", Toast.LENGTH_LONG).show();
                }

            }
        });


    }


}
