package com.example.lishuai.modedemo;


import java.io.Serializable;

public class SaveBackBean extends BeasBean implements Serializable {

    public DataBack data;

    public DataBack getData() {
        return data;
    }

    public void setData(DataBack data) {
        this.data = data;
    }

    public class DataBack {
        private int code;//大于0 返回1，小于等于0 返回2 不成立返回3

        public void setCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

    }
}
