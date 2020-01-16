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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private Context myContext;
    private EditText edSend1, edSend2;
    private TextView tvSend;
    private MyNewDialog myNewDialog;
    private ArrayList<String> selectStirng = new ArrayList<>();

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
        myNewDialog = new MyNewDialog();
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
        selectStirng.clear();
        OkHpptSend.sendOkHttpPost(RequestUrl.login, LoginDataBean.class, new RenInterFace<LoginDataBean>() {
            @Override
            protected void renData(LoginDataBean clazz) {
                if (clazz.code == 200) {
                    for (LoginDataBean.DataEntity.GroupsEntity bean:clazz.getData().getGroups()) {
                        selectStirng.add(bean.getTeam().trim()+"-"+bean.getTeamMan());
                    }
                    SPSave_Current.getSPSave_Current(myContext).setSP("token", clazz.getData().getToken());
                    showDialog(clazz.getData().getGroups());
                } else {
                    Toast.makeText(myContext, clazz.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, MyApp.getMyGson().toJson(bean));
    }

    /**
     * 点击后要选择对话框
     */
    private void showDialog(final List<LoginDataBean.DataEntity.GroupsEntity> list) {
        myNewDialog.showListDialog(myContext, selectStirng, new MyNewDialog.DialotListViewListene() {
            @Override
            public void listViewListen(int position, String content) {
                SPSave_Current.getSPSave_Current(myContext).setSP("groupId", list.get(position).getId()+"");
                Intent intent = new Intent(MainActivity.this, MyUnfinishedListActiity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
