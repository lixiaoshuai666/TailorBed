package com.example.lishuai.modedemo.NewUtils;

import java.io.Serializable;
import java.util.List;

//废弃，用完，布头
public class DeleteScanBean implements Serializable {
    private double quantity;//长度
    private int spreadingCount;//次数
    private int type;//次数
    private List<ScanBean> fabrics;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public List<ScanBean> getFabrics() {
        return fabrics;
    }

    public void setFabrics(List<ScanBean> fabrics) {
        this.fabrics = fabrics;
    }
}
