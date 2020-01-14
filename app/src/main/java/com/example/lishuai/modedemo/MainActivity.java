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

import com.example.lishuai.modedemo.NewUtils.LoginDataBean;
import com.example.lishuai.modedemo.NewUtils.LoginPostBean;
import com.example.lishuai.modedemo.NewUtils.OkHpptSend;
import com.example.lishuai.modedemo.NewUtils.RenInterFace;
import com.example.lishuai.modedemo.NewUtils.SPSave_Current;

public class MainActivity extends Activity {
    private Context myContext;
    private EditText edSend1, edSend2;
    private TextView tvSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myContext = this;
        WindowUtils.setStatusBar(this);
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
            Toast.makeText(myContext, "请输入工号和密码", Toast.LENGTH_LONG).show();
        } else {
            LoginPostBean loginPostBean = new LoginPostBean();
            loginPostBean.setPassword(edSend2.getText().toString().trim());
            loginPostBean.setUsernameOrEmailOrPhone(edSend1.getText().toString().trim());
            sendIssue(loginPostBean);
        }
    }

    /**
     * 登陆
     */
    private void sendIssue(LoginPostBean bean) {
        OkHpptSend.sendOkHttpPost(RequestUrl.login, LoginDataBean.class, new RenInterFace<LoginDataBean>() {
            @Override
            protected void renData(LoginDataBean clazz) {
                if (clazz.code == 200) {
                    SPSave_Current.getSPSave_Current(myContext).setSP("token", clazz.getData().getToken());
                    Intent intent = new Intent(MainActivity.this, MyUnfinishedListActiity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(myContext, clazz.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, MyApp.getMyGson().toJson(bean));
    }
}
