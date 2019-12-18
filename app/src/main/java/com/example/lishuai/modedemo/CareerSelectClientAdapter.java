package com.example.lishuai.modedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishuai on 2019/1/3.
 */

public class CareerSelectClientAdapter extends RecyclerView.Adapter {
    private List<UnfinishedBean.UnfinishedItemBean> myList;
    private Context mContext;
    private SetRecycListene myListene;
    private RecyclerView myRecyView;
    private ArrayList<String> banXingList;
    private MyNewDialog myNewDialog;
    private boolean isSelect;
    private ArrayList<UnfinishedBean.UnfinishedItemBean> list = new ArrayList<>();

    public CareerSelectClientAdapter(List<UnfinishedBean.UnfinishedItemBean> myList, Context mContext, RecyclerView myRecyView) {
        this.myList = myList;
        this.mContext = mContext;
        this.myRecyView = myRecyView;
        this.banXingList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            this.banXingList.add(i + "");
        }
        this.myNewDialog = new MyNewDialog();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_list, parent, false);
        return new CareerSelectClientAdapter.Myviewholders(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final CareerSelectClientAdapter.Myviewholders myviewholders = (CareerSelectClientAdapter.Myviewholders) holder;
        final UnfinishedBean.UnfinishedItemBean unfinishedItemBean = myList.get(position);
        myviewholders.tvBanXing.setText(unfinishedItemBean.getTypeNumber());
        myviewholders.edCenggao.setTag(unfinishedItemBean);
        myviewholders.edJianshu.setTag(unfinishedItemBean);
        myviewholders.edBenciHuanpian.setTag(unfinishedItemBean);
        myviewholders.edBenciCaijian.setTag(unfinishedItemBean);
        myviewholders.edCenggao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UnfinishedBean.UnfinishedItemBean tag = (UnfinishedBean.UnfinishedItemBean) myviewholders.edCenggao.getTag();
                if (s.toString().isEmpty()) {
                    tag.setFloor(0);
                } else {
                    tag.setFloor(Integer.parseInt(s.toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        myviewholders.edBenciCaijian.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UnfinishedBean.UnfinishedItemBean tag = (UnfinishedBean.UnfinishedItemBean) myviewholders.edBenciCaijian.getTag();
                if (s.toString().isEmpty()) {
                    tag.setQuantity(0);
                } else {
                    tag.setQuantity(Integer.parseInt(s.toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        myviewholders.edJianshu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UnfinishedBean.UnfinishedItemBean tag = (UnfinishedBean.UnfinishedItemBean) myviewholders.edJianshu.getTag();
                if (s.toString().isEmpty()){
                    tag.setTypeQuantity(0);
                }else {
                    tag.setTypeQuantity(Integer.parseInt(s.toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        myviewholders.edBenciHuanpian.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UnfinishedBean.UnfinishedItemBean tag = (UnfinishedBean.UnfinishedItemBean) myviewholders.edBenciHuanpian.getTag();
                if (s.toString().isEmpty()) {
                    tag.setChangePiecesQuantity(0);
                } else {
                    tag.setChangePiecesQuantity(Integer.parseInt(s.toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if (unfinishedItemBean.getFloor()==0){
            myviewholders.edCenggao.setText("");
        }else {
            myviewholders.edCenggao.setText(unfinishedItemBean.getFloor()+"");
        }
        if (unfinishedItemBean.getTypeQuantity()==0){//件数
            myviewholders.edJianshu.setText("");
        }else {
            myviewholders.edJianshu.setText(unfinishedItemBean.getTypeQuantity()+"");
        }
        if (unfinishedItemBean.getQuantity()==0){//本次裁剪
            myviewholders.edBenciCaijian.setText( "");
        }else {
            myviewholders.edBenciCaijian.setText(unfinishedItemBean.getQuantity()+ "");
        }
        if (unfinishedItemBean.getChangePiecesQuantity()==0){//换片
            myviewholders.edBenciHuanpian.setText("");
        }else {
            myviewholders.edBenciHuanpian.setText(unfinishedItemBean.getChangePiecesQuantity() + "");
        }
        myviewholders.tvBanXing.setText(unfinishedItemBean.getTypeGroup());
        myviewholders.tvFuKuan.setText("幅宽:" + unfinishedItemBean.getFabricWidth() + "");
        myviewholders.tvChanPinNum.setText("产品编号:" + unfinishedItemBean.getProductCode());
        myviewholders.tvBanHao.setText("版号:" + unfinishedItemBean.getTypeNumber());
        myviewholders.tvGongDan.setText("工单:" + unfinishedItemBean.getWorkOrderNo());
        myviewholders.tvTime.setText("出货日期:" + unfinishedItemBean.getDueDate());

        if (!unfinishedItemBean.isSelect()) {
            myviewholders.ivSelect.setImageResource(R.mipmap.tool_addr_checkbox_normal);
        } else {
            myviewholders.ivSelect.setImageResource(R.mipmap.tool_addr_checkbox_checked);
        }
        myviewholders.edCenggao.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!isSelect) {
                    Toast.makeText(mContext, "请选择布料编号", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
        myviewholders.edJianshu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (!isSelect) {
                    Toast.makeText(mContext, "请选择布料编号", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
        myviewholders.ivSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelect) {
                    Toast.makeText(mContext, "请选择布料编号", Toast.LENGTH_LONG).show();
                    return;
                }
                if (unfinishedItemBean.isSelect()) {
                    myviewholders.ivSelect.setImageResource(R.mipmap.tool_addr_checkbox_normal);
                    unfinishedItemBean.setSelect(false);
                } else {
                    myviewholders.ivSelect.setImageResource(R.mipmap.tool_addr_checkbox_checked);
                    unfinishedItemBean.setSelect(true);
                }
            }
        });
        myviewholders.llBanXing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myNewDialog.showListDialog(mContext, banXingList, new MyNewDialog.DialotListViewListene() {
                    @Override
                    public void listViewListen(int position, String content) {
                        myviewholders.tvBanXing.setText(content);
                        unfinishedItemBean.setTypeGroup(content);
                    }
                });

            }
        });


    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class Myviewholders extends RecyclerView.ViewHolder {
        private TextView tvBanHao, tvBanXing, tvTime, tvGongDan, tvFuKuan, tvChanPinNum, tvChangDu;
        private EditText edCenggao, edJianshu, edBenciCaijian, edBenciHuanpian;
        private ImageView ivSelect;
        private LinearLayout llSelect, llBanXing;

        public Myviewholders(View itemView) {
            super(itemView);
            llSelect = itemView.findViewById(R.id.ll_select);
            ivSelect = itemView.findViewById(R.id.iv_select);
            edCenggao = itemView.findViewById(R.id.ed_cenggao);
            edJianshu = itemView.findViewById(R.id.ed_jianshu);
            tvBanHao = itemView.findViewById(R.id.tv_banhao);
            tvBanXing = itemView.findViewById(R.id.tv_banxing);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvGongDan = itemView.findViewById(R.id.tv_gongdan);
            tvFuKuan = itemView.findViewById(R.id.tv_fukuan);
            tvChangDu = itemView.findViewById(R.id.tv_changdu);
            tvChanPinNum = itemView.findViewById(R.id.tv_chanpin_number);
            llBanXing = itemView.findViewById(R.id.ll_banxing);
            edBenciCaijian = itemView.findViewById(R.id.ed_bencicaijian);
            edBenciHuanpian = itemView.findViewById(R.id.ed_bencihuanpian);
        }
    }


    /**
     * 获取选择的条目
     */
    public ArrayList<UnfinishedBean.UnfinishedItemBean> getListData() {
        list.clear();
        for (UnfinishedBean.UnfinishedItemBean bean : myList) {
            if (bean.isSelect() && (bean.getFloor()==0 || bean.getQuantity()==0 || bean.getTypeGroup().isEmpty())) {
                return new ArrayList<>();
            } else if (bean.isSelect()) {
                list.add(bean);
            }
        }
        return list;
    }

    public void setInterListent(SetRecycListene recycListene) {
        myListene = recycListene;
    }

    public interface SetRecycListene {
        void setListene(int position);
    }

    /**
     * 是否可选择
     *
     * @param isSelect
     */
    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }
}
