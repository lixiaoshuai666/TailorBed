package com.example.lishuai.modedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lishuai.modedemo.NewUtils.IntentScanBean;
import com.example.lishuai.modedemo.NewUtils.ScanBean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 扫一扫列表页
 */
public class MyScanActivity extends Activity {
    private Context myContext;
    private IntentScanBean scanBean;
    private TextView tvTitle, tvIssue, tvDelete;
    private RelativeLayout rlBack;
    private EditText edScan;
    private String fuKuan = "1.53";
    private ArrayList<ScanBean> myList = new ArrayList<>();
    private RecyclerView myRecyCler;
    private CareerSelectScanAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        myContext = this;
        setTranslucentStatus();
        WindowUtils.setStatusBar(this);
        Intent intent = getIntent();
        scanBean = (IntentScanBean) intent.getSerializableExtra("scanBean");
        initView();
    }

    private void initView() {
        tvTitle = findViewById(R.id.tv_title);
        rlBack = findViewById(R.id.rl_back);
        tvIssue = findViewById(R.id.tv_issue);
        edScan = findViewById(R.id.et_sanc);
        myRecyCler = findViewById(R.id.recy_view);
        tvDelete = findViewById(R.id.tv_delete);
        tvTitle.setText("扫码页");
        tvIssue.setText("保存");
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setEditScan();
        myAdapter = new CareerSelectScanAdapter(myList, myContext, myRecyCler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyCler.setLayoutManager(linearLayoutManager);
        myRecyCler.setAdapter(myAdapter);
    }

    private void setEditScan() {
        if (android.os.Build.VERSION.SDK_INT <= 10) {
            edScan.setInputType(InputType.TYPE_NULL);
        } else {
            Class<EditText> cls = EditText.class;
            Method method;
            try {
                method = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                method.setAccessible(true);
                method.invoke(edScan, false);
            } catch (Exception e) {

            }

        }
        edScan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                closeKeybord(edScan, myContext);
                return false;
            }
        });
        edScan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString().trim())) {
                    addList(s.toString().trim());
                }
            }
        });
        tvIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ScanBean> listData = myAdapter.getListData();
                if (listData.size() == 0) {
                    Toast.makeText(myContext, "你未选择条目或未输入理论幅宽", Toast.LENGTH_LONG).show();
                }else {
                    finish();
                }

            }
        });
        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ScanBean> listData = myAdapter.getListData();
                for (ScanBean bean:listData) {
                    myList.remove(bean);
                }
                myAdapter.notifyDataSetChanged();
            }
        });

    }

    private void addList(String s) {
        List<String> strings = Arrays.asList(s.split(","));
        if (strings.size() > 2) {
            ScanBean scanBean = new ScanBean();
            scanBean.setfTheoryFabricWidth(fuKuan);
            scanBean.setfFabricCode(strings.get(0));
            scanBean.setfReelNumber(strings.get(1));
            scanBean.setfLotNumber(strings.get(2));
            scanBean.setfActualFabricWidth(strings.get(3));
            if (!myList.contains(scanBean)) {
                myList.add(scanBean);
                myAdapter.notifyDataSetChanged();
            }else {
                Toast.makeText(myContext, "重复扫码", Toast.LENGTH_LONG).show();
            }
        }
        edScan.setText("");
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

    //关闭软件盘
    public static void closeKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
}
