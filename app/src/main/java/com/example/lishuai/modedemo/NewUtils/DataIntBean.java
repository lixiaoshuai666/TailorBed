package com.example.lishuai.modedemo.NewUtils;

import com.example.lishuai.modedemo.BeasBean;

import java.io.Serializable;

public class DataIntBean extends BeasBean implements Serializable {
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
