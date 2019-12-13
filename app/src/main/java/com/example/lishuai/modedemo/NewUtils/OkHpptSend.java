package com.example.lishuai.modedemo.NewUtils;

import android.util.Log;

import com.example.lishuai.modedemo.BeasBean;
import com.example.lishuai.modedemo.MyApp;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHpptSend {


    /**
     * 请求核算系统的接口
     *
     * @param url2
     */
    public static <T extends BeasBean> void sendOkHttp(final String url2, final Class<T> clazz, final RenInterFace renInterFace) {
        Log.e("TAG", url2);
        new Thread() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                final Request request = new Request.Builder().url(url2).get()
                        .addHeader("content-type", "application/json").build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        String string = response.body().string();
                        LogUtils.logD(string);
                        Gson gson = new Gson();
                        T bean = null;
                        try {
                            bean = gson.fromJson(string, clazz);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        final BeasBean myBean = bean;
                        MyApp.getHandler().post(new Runnable() {
                            @Override
                            public void run() {
                                if (myBean.code == 200) {
                                    renInterFace.renData(myBean);
                                }
                            }
                        });
                    }
                });

            }
        }.start();
    }

    /**
     * 请求核算系统的接口
     *
     * @param url2
     */
    public static <T extends BeasBean> void sendOkHttpPost(final String url2, final Class<T> clazz, final RenInterFace renInterFace, final String json) {
        Log.e("TAG", url2+"---"+json);
        new Thread() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                final Request request = new Request.Builder().url(url2).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json))
                        .addHeader("content-type", "application/json").build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        String string = response.body().string();
                        LogUtils.logD(string);
                        Gson gson = new Gson();
                        T bean = null;
                        try {
                            bean = gson.fromJson(string, clazz);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        final BeasBean myBean = bean;
                        MyApp.getHandler().post(new Runnable() {
                            @Override
                            public void run() {
                                renInterFace.renData(myBean);
                            }
                        });
                    }
                });

            }
        }.start();
    }


}
