package com.example.lishuai.modedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Context myContext;
    private EditText edSend1, edSend2;
    private TextView tvSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myContext = this;
        initView();
    }

    private void initView() {
        edSend1 = findViewById(R.id.ed_send1);
        edSend2 = findViewById(R.id.ed_send2);
        tvSend = findViewById(R.id.tv_send);
        tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLoging();
            }
        });
    }

    private void sendLoging() {
        if (TextUtils.isEmpty(edSend1.getText().toString().trim()) || TextUtils.isEmpty(edSend2.getText().toString().trim())) {
            Toast.makeText(myContext, "请输入工号", Toast.LENGTH_LONG).show();
        } else if (!edSend1.getText().toString().trim().equals(edSend2.getText().toString().trim())) {
            Toast.makeText(myContext, "请确认工号", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, MyListActivity.class);
            intent.putExtra("loginNumber", edSend1.getText().toString().trim());
            startActivity(intent);
        }
    }
}
