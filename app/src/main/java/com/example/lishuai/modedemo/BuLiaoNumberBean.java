package com.example.lishuai.modedemo;

import java.util.List;

/**
 * 布料编号的Bean
 */
public class BuLiaoNumberBean extends BeasBean{
    private List<String> data;

    public List<String> getMyList() {
        return data;
    }

    public void setMyList(List<String> myList) {
        this.data = myList;
    }
}
