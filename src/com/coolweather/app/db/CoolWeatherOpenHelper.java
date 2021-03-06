package com.coolweather.app.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper{
	/*因为父类中的构造函数是有参，所以子类中得调用*/
	public CoolWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	/*Provice表建表语句*/
	public static final String CREATE_PROVINCE="create table Province("
			+ "id integer primary key autoincrement,"
			+ "province_name text,"
			+ "provice_code text)";
	/*	City表建表语句*/
	public static final String CREATE_CITY="create table City("
			+ "id integer primary key autoincrement,"
			+ "city_name text,"
			+ "city_code text,"
			+ "province_id integer)";
	/*	County表建表语句*/
	public static final String CREATE_COUNTY="create table County("
			+ "id integer primary key autoincrement,"
			+ "county_name text,"
			+ "county_code text,"
			+ "city_id integer)";
	@Override
	/*	父类中得抽象方法创建表*/
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE);
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNTY);
	}
	@Override
	/*数据库升级*/
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
