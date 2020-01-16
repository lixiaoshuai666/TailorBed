package com.example.lishuai.modedemo.NewUtils;

import java.io.Serializable;
import java.util.List;

//废弃，用完，布头
public class DeleteScanBean implements Serializable {
    private int quantity;//长度
    private int spreadingCount;//次数
    private List<ScanBean> fabrics;

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

    public List<ScanBean> getFabrics() {
        return fabrics;
    }

    public void setFabrics(List<ScanBean> fabrics) {
        this.fabrics = fabrics;
    }
}
