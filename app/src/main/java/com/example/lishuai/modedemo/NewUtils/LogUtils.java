package com.example.lishuai.modedemo.NewUtils;

import android.util.Log;

public class LogUtils {
    private static boolean isLog=true;


    public static void logE(String str){
        if (isLog){
            Log.e("TAG",str);
        }
    }

    public static void logD(String str){
        if (isLog){
            Log.d("TAG",str);
        }
    }


}
