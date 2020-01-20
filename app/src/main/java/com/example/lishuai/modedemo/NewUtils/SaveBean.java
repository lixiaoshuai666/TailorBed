package com.example.lishuai.modedemo.NewUtils;

import com.example.lishuai.modedemo.UnfinishedBean;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveBean implements Serializable {
    private ArrayList<ScanBean> fabrics;
    private ArrayList<UnfinishedBean.UnfinishedItemBean> tailoringPlans;
    private int floor; //层高
    private double quantity; //长度
    private int spreadingCount; //拉布次数
    private int taskId; //保存需要的id
    private int spreadingType; //0拉布正常，1表示拉布完成后可以继续

    public int getSpreadingType() {
        return spreadingType;
    }

    public void setSpreadingType(int spreadingType) {
        this.spreadingType = spreadingType;
    }

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

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getSpreadingCount() {
        return spreadingCount;
    }

    public void setSpreadingCount(int spreadingCount) {
        this.spreadingCount = spreadingCount;
    }
}
