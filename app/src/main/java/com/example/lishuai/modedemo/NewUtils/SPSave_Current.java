package com.example.lishuai.modedemo.NewUtils;

import android.content.Context;
import android.content.SharedPreferences;

/***
 * SPSave_Current :SPSave 的当前使用者电话信息及app是否是第一次使用
 * 作者：james on 2018/1/15 15:19
 *
 * **/
public class SPSave_Current {
	private Context context;
	private SharedPreferences mySharedPreferences;
	private SharedPreferences.Editor editor;
	/***数据存储*单例*/
	private static SPSave_Current spSave_current = null;
	public static SPSave_Current getSPSave_Current(Context context){
		if(spSave_current==null){
			spSave_current =new SPSave_Current(context);
		}
		return spSave_current;
	}
	public SPSave_Current(Context context) {
		super();
		this.context = context;
		mySharedPreferences= context.getSharedPreferences("ecezuserphone", Context.MODE_MULTI_PROCESS);
		editor = mySharedPreferences.edit();
	}

	public String getSP(String key){
		return mySharedPreferences.getString(key, "");
	}

	public int getIntSP(String key){
		return mySharedPreferences.getInt(key, 0);
	}

	public void setSP(String key, int value){
    	editor.putInt(key, value);
    	editor.commit();
    }

    public void setSP(String key, String value){
    	editor.putString(key, value);
    	editor.commit();
    }
}
