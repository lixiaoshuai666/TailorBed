package com.example.lishuai.modedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lishuai.modedemo.NewUtils.ScanBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishuai on 2019/1/3.
 */

public class CareerSelectScanAdapter extends RecyclerView.Adapter {
    private List<ScanBean> myList;
    private Context mContext;
    public ArrayList<ScanBean> list = new ArrayList<>();
    private SetRecycListene myListene;

    public CareerSelectScanAdapter(List<ScanBean> myList, Context mContext, RecyclerView myRecyView) {
        this.myList = myList;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scan_card_list, parent, false);
        return new CareerSelectScanAdapter.Myviewholders(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final CareerSelectScanAdapter.Myviewholders myviewholders = (CareerSelectScanAdapter.Myviewholders) holder;
        final ScanBean bean=myList.get(position);
        myviewholders.edLiLunChangDu.setTag(bean);
        myviewholders.edLiLunChangDu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ScanBean tag = (ScanBean) myviewholders.edLiLunChangDu.getTag();
                tag.setfTheoryWidth(s + "");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        myviewholders.edLiLunChangDu.setText(bean.getfTheoryWidth());
        myviewholders.tvBuLiaoNumber.setText("布料编码:"+bean.getfFabricCode());
        myviewholders.tvBuPiNumber.setText("布批号:"+bean.getfLotNumber());
        myviewholders.tvJuanHao.setText("卷号:" + bean.getfReelNumber());
        myviewholders.tvShiJiFuKuan.setText("实际幅宽:" + bean.getfActualFabricWidth());
        myviewholders.tvLiLunFuKuan.setText(bean.getfTheoryFabricWidth());
        if (bean.getfActualFabricWidth().equals(bean.getfTheoryFabricWidth())){
            myviewholders.tvLiLunFuKuan.setTextColor(mContext.getResources().getColor(R.color.color_8a000000));
            //黑色
        }else {
            //红色
            myviewholders.tvLiLunFuKuan.setTextColor(mContext.getResources().getColor(R.color.color_f8726f));
        }
        if (!bean.isSelect()) {
            myviewholders.ivSelect.setImageResource(R.mipmap.tool_addr_checkbox_normal);
        } else {
            myviewholders.ivSelect.setImageResource(R.mipmap.tool_addr_checkbox_checked);
        }
        myviewholders.ivSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean.isSelect()) {
                    myviewholders.ivSelect.setImageResource(R.mipmap.tool_addr_checkbox_normal);
                    bean.setSelect(false);
                } else {
                    myviewholders.ivSelect.setImageResource(R.mipmap.tool_addr_checkbox_checked);
                    bean.setSelect(true);
                }
                myListene.setListene(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class Myviewholders extends RecyclerView.ViewHolder {
        private TextView tvJuanHao, tvBuLiaoNumber, tvBuPiNumber, tvShiJiFuKuan, tvLiLunFuKuan;
        private EditText edLiLunChangDu;
        private ImageView ivSelect;
        private LinearLayout llSelect;

        public Myviewholders(View itemView) {
            super(itemView);
            llSelect = itemView.findViewById(R.id.ll_select);
            ivSelect = itemView.findViewById(R.id.iv_select);
            edLiLunChangDu = itemView.findViewById(R.id.ed_lilun_changdu);
            tvJuanHao = itemView.findViewById(R.id.tv_juanhao);
            tvBuLiaoNumber = itemView.findViewById(R.id.tv_buliao_number);
            tvBuPiNumber = itemView.findViewById(R.id.tv_bupi_number);
            tvShiJiFuKuan = itemView.findViewById(R.id.tv_shiji_fukuan);
            tvLiLunFuKuan = itemView.findViewById(R.id.tv_lilun_fukuan);
        }
    }


    /**
     * 获取选择的条目
     */
    public ArrayList<ScanBean> getListData() {
        list.clear();
        for (ScanBean bean : myList) {
            if (bean.isSelect() && bean.getfTheoryWidth().isEmpty()) {
                return new ArrayList<>();
            } else if (bean.isSelect()) {
                list.add(bean);
            }
        }
        return list;
    }
    /**
     * 获取选择的条目
     */
    public int getListSelect() {
        list.clear();
        int i=0;
        for (ScanBean bean : myList) {
            if (bean.isSelect()){
                i++;
            }
        }
        return i;
    }

    /**
     * 获取选择的要删除的条目
     */
    public ArrayList<ScanBean> getRemakeListData() {
        list.clear();
        for (ScanBean bean : myList) {
            if (bean.isSelect()) {
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

}
