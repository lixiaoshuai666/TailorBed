package com.example.lishuai.modedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lishuai.modedemo.NewUtils.IntentScanBean;
import com.example.lishuai.modedemo.NewUtils.OkHpptSend;
import com.example.lishuai.modedemo.NewUtils.RenInterFace;

import java.util.ArrayList;

public class MyUnfinishedListActiity extends Activity {

    private Context myContext;
    private String loginNumber;
    private MyNewDialog myNewDialog;
    private ArrayList<String> selectStirng;
    private RecyclerView recyView;
    private ArrayList<UnfinishedBean.UnfinishedItemBean> strList;
    private CareerSelectClientAdapter myAdapter;
    private TextView tvTitle, tvIssue, tvQr;
    private RelativeLayout rlBack;
    private String unfinishedListUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_unfinished_list);
        myContext = this;
        Intent intent = getIntent();
        loginNumber = intent.getStringExtra("loginNumber");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);// 设置默认键盘不弹出
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 设置设备为竖屏模式
        setTranslucentStatus();
        WindowUtils.setStatusBar(this);
        initView();
    }

    private void initView() {
        recyView = findViewById(R.id.recy_view);
        tvTitle = findViewById(R.id.tv_title);
        tvIssue = findViewById(R.id.tv_issue);
        rlBack = findViewById(R.id.rl_back);
        tvQr = findViewById(R.id.tv_qr);
        strList = new ArrayList<>();
        myAdapter = new CareerSelectClientAdapter(strList, myContext, recyView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyView.setLayoutManager(linearLayoutManager);
        recyView.setAdapter(myAdapter);
        OkHpptSend.sendOkHttp(RequestUrl.fabricCodes, BuLiaoNumberBean.class, new RenInterFace<BuLiaoNumberBean>() {
            @Override
            protected void renData(BuLiaoNumberBean bean) {
                for (String str : bean.getMyList()) {
                    selectStirng.add(str);
                }
            }
        });
        initGetListData("");
        initData();
    }

    private void initData() {
        myNewDialog = new MyNewDialog();
        selectStirng = new ArrayList<>();
        initListion();


    }

    private void initListion() {
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNewDialog.showListDialog(myContext, selectStirng, new MyNewDialog.DialotListViewListene() {
                    @Override
                    public void listViewListen(int position, String content) {
                        tvTitle.setText(content);
                        //选择布料编号后，刷新
                        initGetListData(content);
                        myAdapter.setIsSelect(true);
                    }
                });
            }
        });
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //提交

            }
        });
        tvQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //扫一扫
                ArrayList<UnfinishedBean.UnfinishedItemBean> listData = myAdapter.getListData();
                if (listData.size() == 0) {
                    Toast.makeText(myContext, "你未选择条目或层高、件数未输入,版型未选择", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(myContext, MyScanActivity.class);
                    intent.putExtra("scanBean", new IntentScanBean(listData));
                    intent.putExtra("buLiaoNumber", tvTitle.getText().toString().trim());
                    startActivityForResult(intent,10);
                }
            }
        });


    }

    /**
     * 请求接口并刷新
     *
     * @param string
     */
    private void initGetListData(String string) {
        if (string.isEmpty()) {
            unfinishedListUrl = RequestUrl.listForPda;
        } else {
            unfinishedListUrl = RequestUrl.listForPda + "?fabricCode=" + string;
        }
        OkHpptSend.sendOkHttp(unfinishedListUrl, UnfinishedBean.class, new RenInterFace<UnfinishedBean>() {
            @Override
            protected void renData(UnfinishedBean clazz) {
                strList.clear();
                strList.addAll(clazz.getData());
                myAdapter.notifyDataSetChanged();
            }
        });
    }


    /**
     * 设置状态栏透明
     */
    protected void setTranslucentStatus() {


        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(Color.TRANSPARENT);
            //设置导航栏颜色
            window.setNavigationBarColor(Color.BLACK);
            ViewGroup contentView = ((ViewGroup) findViewById(android.R.id.content));
            View childAt = contentView.getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(true);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }
}
