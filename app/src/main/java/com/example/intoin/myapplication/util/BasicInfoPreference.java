package com.example.intoin.myapplication.util;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
public class BasicInfoPreference {
	private final String PREF_NAME = "com.example.intoin";

		
	public final static String PREF_LOGIN_CID = "PREF_LOGIN_CID";
	public final static String PREF_LOGINID = "PREF_LOGINID";
	public final static String PREF_LOGINNAME = "PREF_LOGINNAME";


	
	static Context ctx;


	public BasicInfoPreference(Context ctx) {
		this.ctx = ctx;
	}
	public BasicInfoPreference() {

	}

	public void bpClear(){
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME,Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.clear();
		editor.commit();
	}

	public void put(String key, String value) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();

		editor.putString(key, value);
		editor.commit();
	}

	public void put(String key, boolean value) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME,Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();

		editor.putBoolean(key, value);
		editor.commit();
	}

	public void put(String key, int value) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME,Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();

		editor.putInt(key, value);
		editor.commit();
	}
	
	public void put(String key, long value) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME,Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();

		editor.putLong(key, value);
		
		editor.commit();
	}


	public String getValue(String key, String dftValue) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME,Activity.MODE_PRIVATE);

		try {
			return pref.getString(key, dftValue);
		} catch (Exception e) {
			return dftValue;
		}

	}

	public int getValue(String key, int dftValue) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME,Activity.MODE_PRIVATE);

		try {
			return pref.getInt(key, dftValue);
		} catch (Exception e) {
			return dftValue;
		}

	}

	public boolean getValue(String key, boolean dftValue) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME,Activity.MODE_PRIVATE);
		

		try {
			return pref.getBoolean(key, dftValue);
		} catch (Exception e) {
			return dftValue;
		}
	}
	
	public long getValue(String key, long dftValue) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME,Activity.MODE_PRIVATE);
		

		try {
			return pref.getLong(key, dftValue);
		} catch (Exception e) {
			return dftValue;
		}
	}
	
	public void remove(String key) {
		SharedPreferences pref = ctx.getSharedPreferences(PREF_NAME,Activity.MODE_PRIVATE);		
		SharedPreferences.Editor editor = pref.edit();
		
		editor.remove(key);
		editor.commit();
	}
}
