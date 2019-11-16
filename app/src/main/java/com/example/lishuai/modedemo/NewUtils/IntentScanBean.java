package com.example.lishuai.modedemo.NewUtils;

import com.example.lishuai.modedemo.UnfinishedBean;

import java.io.Serializable;
import java.util.ArrayList;

public class IntentScanBean implements Serializable {

    private ArrayList<UnfinishedBean.UnfinishedItemBean> scanList;

    public IntentScanBean(ArrayList<UnfinishedBean.UnfinishedItemBean> scanList) {
        this.scanList = scanList;
    }

    public ArrayList<UnfinishedBean.UnfinishedItemBean> getScanList() {
        return scanList;
    }

    public void setScanList(ArrayList<UnfinishedBean.UnfinishedItemBean> scanList) {
        this.scanList = scanList;
    }
}
