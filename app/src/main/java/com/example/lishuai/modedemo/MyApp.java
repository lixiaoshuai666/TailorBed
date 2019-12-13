package com.example.lishuai.modedemo;

import android.app.Application;
import android.os.Handler;

import com.google.gson.Gson;

public class MyApp extends Application {
    private static Application myApp;
    private static Handler mainHandler;
    private static Gson myGson;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }

    public static Application getApp() {
        return myApp;
    }

    /**
     * 获取全局的Handler
     * @return
     */
    public static Handler getHandler() {
        if (mainHandler == null) {
            return mainHandler = new Handler(MyApp.getApp().getMainLooper());
        } else {
            return mainHandler;
        }
    }
    public static Gson getMyGson(){
        if (myGson==null){
            myGson=new Gson();
        }
        return myGson;
    }

}
