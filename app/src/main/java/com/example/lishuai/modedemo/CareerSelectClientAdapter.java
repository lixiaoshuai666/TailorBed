package com.example.lishuai.modedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lishuai on 2019/1/3.
 */

public class CareerSelectClientAdapter extends RecyclerView.Adapter {
    private List<String> myList;
    private Context mContext;
    public int myPosition = -1;
    private SetRecycListene myListene;
    private RecyclerView myRecyView;
    private int objectId;

    public CareerSelectClientAdapter(List<String> myList, Context mContext, RecyclerView myRecyView) {
        this.myList = myList;
        this.mContext = mContext;
        this.myRecyView = myRecyView;
    }

    public CareerSelectClientAdapter(List<String> myList, Context mContext, RecyclerView myRecyView, int objectId) {
        this.myList = myList;
        this.mContext = mContext;
        this.myRecyView = myRecyView;
        this.objectId = objectId;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new CareerSelectClientAdapter.Myviewholders(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final CareerSelectClientAdapter.Myviewholders myviewholders = (CareerSelectClientAdapter.Myviewholders) holder;
//        NewGlideUtils.glideNewCircular(mContext, myList.get(position).getCustomerLogo(), myviewholders.ivClientHead, 4);
//        myviewholders.tvClientName.setText(myList.get(position).getCustomerName());
//        if (myList.get(position).getLables() == null || myList.get(position).getLables().size() == 0) {
//            myviewholders.tagLayout.setVisibility(View.GONE);
//        } else {
//            myviewholders.tagLayout.setAdapter(new LabelsUtilsAdapter(mContext, myList.get(position).getLables(), 1));
//            myviewholders.tagLayout.setVisibility(View.VISIBLE);
//        }
//        if (myPosition == position) {
//            myviewholders.ivSelectClient.setImageResource(R.mipmap.tool_addr_checkbox_checked);
//        } else {
//            myviewholders.ivSelectClient.setImageResource(R.mipmap.tool_addr_checkbox_normal);
//        }
//        myviewholders.reSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (myPosition == position) {
//                    myPosition = -1;
//                    myviewholders.ivSelectClient.setImageResource(R.mipmap.tool_addr_checkbox_normal);
//                } else if (myPosition == -1) {
//                    myPosition = position;
//                    myviewholders.ivSelectClient.setImageResource(R.mipmap.tool_addr_checkbox_checked);
//                } else {
//                    CareerSelectClientAdapter.Myviewholders vhNew = (CareerSelectClientAdapter.Myviewholders) myRecyView.findViewHolderForLayoutPosition(myPosition);
//                    vhNew.ivSelectClient.setImageResource(R.mipmap.career_uncheck);
//                    myviewholders.ivSelectClient.setImageResource(R.mipmap.tool_addr_checkbox_checked);
//                    myPosition = position;
//                }
//                myListene.setListene(myPosition);
//                objectId=0;//如果分页前没有拉到已选择的数据，并且选择了一个，那么回显的逻辑就不能要了。
//            }
//        });
//        if (objectId != 0 && objectId == myList.get(position).getObjectId()) {
//            //这里处理已选择的，回显逻辑
//            myviewholders.ivSelectClient.setImageResource(R.mipmap.tool_addr_checkbox_checked);
//            myPosition = position;
//            objectId = 0;
//            myListene.setListene(myPosition);
//        }
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class Myviewholders extends RecyclerView.ViewHolder {

        private TextView tvBanHao,tvBanXing,tvTime,tvGongDan,tvFuKuan,tvBenciCaijian,tvBenciHuanpian;
        private EditText edCenggao,edJianshu;
        private ImageView ivSelect;
        private LinearLayout llSelect;

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
            tvBenciCaijian = itemView.findViewById(R.id.tv_bencicaijian);
            tvBenciHuanpian = itemView.findViewById(R.id.tv_bencihuanpian);
        }
    }

    public void setInterListent(SetRecycListene recycListene) {
        myListene = recycListene;
    }

    public interface SetRecycListene {
        void setListene(int position);
    }
}
