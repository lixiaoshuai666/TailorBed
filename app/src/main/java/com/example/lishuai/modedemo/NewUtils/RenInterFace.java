package com.example.lishuai.modedemo.NewUtils;

import com.example.lishuai.modedemo.BeasBean;

/**
 * 请求的一个回调函数
 * @param <T>
 */
public  abstract class RenInterFace<T extends BeasBean> {
    /**
     * 请求成功
     *
     * @param clazz
     */
    protected abstract void renData(T clazz);
}