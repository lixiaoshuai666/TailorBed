package com.example.lishuai.modedemo;

import android.app.Application;
import android.os.Handler;

public class MyApp extends Application {
    private static Application myApp;
    private static Handler mainHandler;

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

}
