package com.example.lishuai.modedemo.NewUtils;

import com.example.lishuai.modedemo.UnfinishedBean;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveBean implements Serializable {
    private ArrayList<ScanBean> fabrics;
    private ArrayList<UnfinishedBean.UnfinishedItemBean> tailoringPlans;
    private int floor; //层高
    private int quantity; //长度
    private int spreadingCount; //拉布次数

    public ArrayList<ScanBean> getFabrics() {
        return fabrics;
    }

    public void setFabrics(ArrayList<ScanBean> fabrics) {
        this.fabrics = fabrics;
    }

    public ArrayList<UnfinishedBean.UnfinishedItemBean> getTailoringPlans() {
        return tailoringPlans;
    }

    public void setTailoringPlans(ArrayList<UnfinishedBean.UnfinishedItemBean> tailoringPlans) {
        this.tailoringPlans = tailoringPlans;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSpreadingCount() {
        return spreadingCount;
    }

    public void setSpreadingCount(int spreadingCount) {
        this.spreadingCount = spreadingCount;
    }
}
