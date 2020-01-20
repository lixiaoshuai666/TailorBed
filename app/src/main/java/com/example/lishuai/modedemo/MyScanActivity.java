package com.example.lishuai.modedemo;

import android.app.Activity;
import android.app.Dialog;
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
import android.util.Log;
import android.view.KeyEvent;
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

import com.example.lishuai.modedemo.NewUtils.DataIntBean;
import com.example.lishuai.modedemo.NewUtils.DeleteScanBean;
import com.example.lishuai.modedemo.NewUtils.IntentScanBean;
import com.example.lishuai.modedemo.NewUtils.OkHpptSend;
import com.example.lishuai.modedemo.NewUtils.RenInterFace;
import com.example.lishuai.modedemo.NewUtils.SaveBean;
import com.example.lishuai.modedemo.NewUtils.ScanBean;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

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
    private String buLiaoNumber;
    private TextView tvTitle, tvIssue, tvDelete, tvCengGao;
    private RelativeLayout rlBack;
    private EditText edScan, edChangDu, edLaBuCiShu;
    private double fuKuan;
    private ArrayList<ScanBean> myList = new ArrayList<>();
    private RecyclerView myRecyCler;
    private int taskId;
    private CareerSelectScanAdapter myAdapter;
    private Dialog dialog;
    private ArrayList<ScanBean> listData = new ArrayList<>();
    private int number;
    private int spreadingId = 0;//布头表需要的一个id
    private boolean isFinish;
    private int type;//2 报废 1布头 3用完
    private int spreadingType;////0拉布正常，1表示拉布完成后可以继续

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        myContext = this;
        setTranslucentStatus();
        WindowUtils.setStatusBar(this);
        Intent intent = getIntent();
        scanBean = (IntentScanBean) intent.getSerializableExtra("scanBean");
        buLiaoNumber = intent.getStringExtra("buLiaoNumber");
        taskId = intent.getIntExtra("taskId", 0);
        fuKuan = scanBean.getScanList().get(0).getFabricWidth();
        initView();
    }

    private void initView() {
        tvTitle = findViewById(R.id.tv_title);
        rlBack = findViewById(R.id.rl_back);
        tvIssue = findViewById(R.id.tv_issue);
        edScan = findViewById(R.id.et_sanc);
        myRecyCler = findViewById(R.id.recy_view);
        tvDelete = findViewById(R.id.tv_delete);
        tvCengGao = findViewById(R.id.tv_cenggao);
        edChangDu = findViewById(R.id.ed_changdu);
        edLaBuCiShu = findViewById(R.id.ed_labucishu);
        tvTitle.setText("扫码页");
        tvIssue.setText("保存");
        myAdapter = new CareerSelectScanAdapter(myList, myContext, myRecyCler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyCler.setLayoutManager(linearLayoutManager);
        myRecyCler.setAdapter(myAdapter);
        setEditScan();
    }

    private void setEditScan() {
        edScan.requestFocus();
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
        edLaBuCiShu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String trim = s.toString().trim();
                if (trim.length() > 0 && trim.startsWith("0")) {
                    //首位不能为0
                    s.replace(0, 1, "");
                } else {
                    setCengGao();
                }

            }
        });

        //监听EditText的回车事件
        edScan.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                    if (!TextUtils.isEmpty(edScan.getText().toString().trim())) {
                        addList(edScan.getText().toString().trim());
                    }
                    return true;
                }
                return false;
            }
        });

        tvIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listData.clear();
                listData.addAll(myAdapter.getListData());
                if (listData.size() < 1) {
                    Toast.makeText(myContext, "你未选择条目或未输入理论幅宽", Toast.LENGTH_LONG).show();
                } else if (edChangDu.getText().toString().trim().isEmpty() || edChangDu.getText().toString().trim().isEmpty()) {
                    Toast.makeText(myContext, "请输入长度", Toast.LENGTH_LONG).show();
                } else if (edLaBuCiShu.getText().toString().trim().isEmpty() || edLaBuCiShu.getText().toString().trim().equals("0")) {
                    Toast.makeText(myContext, "请输入拉布次数", Toast.LENGTH_LONG).show();
                } else {
                    number = 0;
                    resetGetNumber(new SetRecycListene() {
                        @Override
                        public void setListene() {
                            number++;
                            if (number < listData.size()) {
                                resetGetNumber(this);
                            } else {
                                sendSavePost();
                            }
                        }
                    });
                }

            }
        });
        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edChangDu.getText().toString().trim()) || TextUtils.isEmpty(edLaBuCiShu.getText().toString().trim())) {
                    Toast.makeText(myContext, "请输入长度和拉布次数", Toast.LENGTH_LONG).show();
                    return;
                }
                deleteItem();
            }
        });

        myAdapter.setInterListent(new CareerSelectScanAdapter.SetRecycListene() {
            @Override
            public void setListene(int position) {
                setCengGao();
                setSelectItem();
            }
        });
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    private void addList(String s) {
        List<String> strings = Arrays.asList(s.split(","));
        getLiLunChangdu(strings);
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

    private void setCengGao() {
        String trim = edLaBuCiShu.getText().toString().trim();
        if (!trim.isEmpty()) {
            tvCengGao.setText("" + (Integer.parseInt(trim) * myAdapter.getListSelect()));
        }
    }

    private void deleteItem() {
        listData.clear();
        listData.addAll(myAdapter.getRemakeListData());
        if (listData.size() < 1) {
            Toast.makeText(myContext, "你未选择条目", Toast.LENGTH_LONG).show();
            return;
        }
        dialog = DialogBuilder.getDialog(myContext, "选中的布卷是否用完、报废、布头？", "用完", "布头", new DialogBuilder.DialogListener3() {
            @Override
            public void leftOnclick() {
                //用完的处理
                isFinish = false;
                type = 3;
                dialog.dismiss();
                deleteScan();
            }

            @Override
            public void rightOnclick() {
                //删除的处理
                isFinish = false;
                type = 1;
                dialog.dismiss();
                deleteScan();
            }

            @Override
            public void centreOnclick() {
                //报废的处理
                isFinish = false;
                type = 2;
                dialog.dismiss();
                deleteScan();
            }
        });
    }

    private void setSelectItem() {
        tvTitle.setText(myList.size() + "/" + myAdapter.getRemakeListData().size());
    }

    @Override
    public void onBackPressed() {
        goBack();
    }

    /**
     * 返回事件
     */
    private void goBack() {
        listData.clear();
        listData.addAll(myAdapter.getRemakeListData());
        if (listData.size() < 1) {
            finishActivity();
            return;
        }
        dialog = DialogBuilder.getDialog(myContext, "该裁剪单还未完成，是否确定执行", new DialogBuilder.DialogListener() {
            @Override
            public void leftOnclick() {
                dialog.dismiss();
            }

            @Override
            public void rightOnclick() {
                dialog.dismiss();
                isBuLiaoExhauht();
            }
        });
    }

    /**
     * 布料是否用完
     */
    private void isBuLiaoExhauht() {
        dialog = DialogBuilder.getDialog(myContext, "布料是否用完？", new DialogBuilder.DialogListener() {
            @Override
            public void leftOnclick() {
                //放到布头表里面
                type = 1;
                dialog.dismiss();
                deleteScan();
            }

            @Override
            public void rightOnclick() {
                dialog.dismiss();
                finishActivity();
            }
        });
    }

    /**
     * 请求保存接口
     */
    private void sendSavePost() {
        tvIssue.setEnabled(false);
        SaveBean saveBean = new SaveBean();
        saveBean.setFabrics(listData);
        saveBean.setTaskId(taskId);
        saveBean.setSpreadingType(spreadingType);
        saveBean.setTailoringPlans(scanBean.getScanList());
        saveBean.setFloor(Integer.parseInt(tvCengGao.getText().toString().trim()));
        saveBean.setQuantity(Double.valueOf(edChangDu.getText().toString().trim()));
        saveBean.setSpreadingCount(Integer.parseInt(edLaBuCiShu.getText().toString().trim()));
        OkHpptSend.sendOkHttpPost(RequestUrl.detail, SaveBackBean.class, new RenInterFace<SaveBackBean>() {
            @Override
            protected void renData(SaveBackBean clazz) {
                tvIssue.setEnabled(true);
                if (clazz.code == 200) {
                    spreadingId = clazz.getData().getSpreadingId();
                    if (clazz.getData().getCode() == 1 || clazz.getData().getCode() == 2) {
                        backDialog(clazz.getData().getCode());
                    } else {
                        Toast.makeText(myContext, clazz.getMessage(), Toast.LENGTH_LONG).show();
                        spreadingType = 0;
                    }

                } else {
                    Toast.makeText(myContext, clazz.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, MyApp.getMyGson().toJson(saveBean));

    }

    /**
     * 删除扫码信息，添加到布头表里面
     */
    private void deleteScan() {
        double quantity = Double.valueOf(edChangDu.getText().toString().trim());
        int spreadingCount = Integer.parseInt(edLaBuCiShu.getText().toString().trim());
        if (quantity < 1 || spreadingCount < 1) {
            Toast.makeText(myContext, "长度和拉布次数必须大于0", Toast.LENGTH_LONG).show();
            return;
        }
        for (ScanBean bean : listData) {
            bean.setSpreadingId(spreadingId);
            if (type == 3) {//用完的话理论长度为0
                bean.setTheoryLength(0);
            }
        }
        DeleteScanBean deleteScanBean = new DeleteScanBean();
        deleteScanBean.setFabrics(listData);
        deleteScanBean.setQuantity(Double.valueOf(edChangDu.getText().toString().trim()));
        deleteScanBean.setSpreadingCount(Integer.parseInt(edLaBuCiShu.getText().toString().trim()));
        deleteScanBean.setType(type);
        OkHpptSend.sendOkHttpPost(RequestUrl.toFabricLeft, BeasBean.class, new RenInterFace() {
            @Override
            protected void renData(BeasBean clazz) {
                if (clazz.code == 200) {
                    deleSelect();
                    if (isFinish) {
                        finishActivity();
                    }
                } else {
                    Toast.makeText(myContext, clazz.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, MyApp.getMyGson().toJson(deleteScanBean));
    }

    /**
     * 根据卷号，查询理论长度
     *
     * @param strings
     */
    private void getLiLunChangdu(final List<String> strings) {
        if (strings.size() < 2) {
            edScan.setText("");
            return;
        }
        if (myList.size() > 0) {
            if (!myList.get(0).getLotNumber().equals(strings.get(2))) {
                Toast.makeText(myContext, "布匹号不一致", Toast.LENGTH_LONG).show();
                edScan.setText("");
                return;
            }
        }
        OkHpptSend.sendOkHttp(RequestUrl.fabricLeftTheoryLength + strings.get(1), GetLILunLeng.class, new RenInterFace<GetLILunLeng>() {
            @Override
            protected void renData(GetLILunLeng clazz) {
                if (clazz.getCode() == 200) {
                    ScanBean scanBean = new ScanBean();
                    scanBean.setTheoryLength(clazz.getData().getTheoryLength());
                    scanBean.setTheoryFabricWidth(fuKuan);
                    scanBean.setFabricCode(strings.get(0));
                    scanBean.setReelNumber(strings.get(1));
                    scanBean.setLotNumber(strings.get(2));
                    scanBean.setActualFabricWidth(Double.parseDouble(strings.get(3)));
                    scanBean.setFagEndList(clazz.getData().getFagEndList());
                    scanBean.setType(clazz.getData().getType());
                    if (clazz.getData().getType() == 3) {//用完
                        Toast.makeText(myContext, "布料已用完", Toast.LENGTH_LONG).show();
                        edScan.setText("");
                    } else if (clazz.getData().getType() == 2) {//报废
                        Toast.makeText(myContext, "布料已报废", Toast.LENGTH_LONG).show();
                        edScan.setText("");
                    } else if (!buLiaoNumber.equals(scanBean.getFabricCode())) {
                        Toast.makeText(myContext, "布料编号不一致", Toast.LENGTH_LONG).show();
                        edScan.setText("");
                    } else if (!myList.contains(scanBean)) {
                        myList.add(scanBean);
                        myAdapter.notifyDataSetChanged();
                        edScan.setText("");
                        setCengGao();
                        setSelectItem();
                    } else {
                        Toast.makeText(myContext, "重复扫码", Toast.LENGTH_LONG).show();
                        edScan.setText("");
                    }
                } else {
                    edScan.setText("");
                    Toast.makeText(myContext, clazz.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * 根据不同的返回，弹不同的dialog
     *
     * @param type
     */
    private void backDialog(int type) {
        if (type == 1) {
            spreadingType = 0;
            dialog = DialogBuilder.getDialog(myContext, "布料是否拉完？", new DialogBuilder.DialogListener() {
                @Override
                public void leftOnclick() {
                    //点击“否”，扫码界面的拉布次数和长度清空，理论长度需重新计算，其它字段保留，
                    // 继续输入拉布次数、长度。点击“保存”，重新计算“剩余需裁剪数量。
                    dialog.dismiss();
                    edChangDu.setText("");
                    edLaBuCiShu.setText("");
                    tvCengGao.setText("");
                    number = 0;
                    resetLiLunNumber(new SetRecycListene() {
                        @Override
                        public void setListene() {
                            number++;
                            if (number < myList.size()) {
                                resetLiLunNumber(this);
                            } else {
                                myAdapter.notifyDataSetChanged();
                            }
                        }
                    });
                }

                @Override
                public void rightOnclick() {
                    //点击“是”，布料剩余数量直接变为0.本扫码界面全部清空，继续扫码,输入拉布次数、长度。(重新上布)。
                    dialog.dismiss();
                    restartView();
                }
            });
        } else {
            spreadingType = 1;
            dialog = DialogBuilder.getDialog(myContext, "是否继续拉布？", new DialogBuilder.DialogListener() {
                @Override
                public void leftOnclick() {
                    //点击“否”，弹出对话框“布料是否用完？“。
                    dialog.dismiss();
                    isFinish = true;
                    isBuLiaoExhauht();
                }

                @Override
                public void rightOnclick() {
                    //点击“是”，返回扫描界面，继续输入拉布次数和长度
                    tvCengGao.setText("");
                    edLaBuCiShu.setText("");
                    edChangDu.setText("");
                    dialog.dismiss();
                }
            });
        }
    }

    /**
     * 重置界面数据
     */
    private void restartView() {
        edLaBuCiShu.setText("");
        edChangDu.setText("");
        tvCengGao.setText("");
        tvTitle.setText("扫码");
        myList.clear();
        myAdapter.notifyDataSetChanged();
    }

    /**
     * 重新获取布料的理论长度
     */
    private void resetLiLunNumber(final SetRecycListene listene) {
        final ScanBean bean = myList.get(number);
        OkHpptSend.sendOkHttp(RequestUrl.fabricLeftTheoryLength + bean.getReelNumber(), GetLILunLeng.class, new RenInterFace<GetLILunLeng>() {
            @Override
            protected void renData(GetLILunLeng clazz) {
                bean.setTheoryLength(clazz.getData().getTheoryLength());
                bean.setFagEndList(clazz.getData().getFagEndList());
                listene.setListene();
            }
        });
    }

    /**
     * 重新获取布料的理论长度
     */
    private void resetGetNumber(final SetRecycListene listene) {
        final ScanBean bean = listData.get(number);
        OkHpptSend.sendOkHttp(RequestUrl.fabricLeftTheoryLength + bean.getReelNumber(), GetLILunLeng.class, new RenInterFace<GetLILunLeng>() {
            @Override
            protected void renData(GetLILunLeng clazz) {
                if (clazz.getData().getTheoryLength() != 0) {
                    bean.setTheoryLength(clazz.getData().getTheoryLength());
                }
                bean.setFagEndList(clazz.getData().getFagEndList());
                listene.setListene();
            }
        });
    }

    /**
     * 删除选中的条目
     */
    private void deleSelect() {
        //删除成功
        for (ScanBean bean : listData) {
            myList.remove(bean);
        }
        myAdapter.notifyDataSetChanged();
        setCengGao();
        setSelectItem();
    }

    public interface SetRecycListene {
        void setListene();
    }

    private void finishActivity() {
        setResult(12);
        finish();
    }
}
