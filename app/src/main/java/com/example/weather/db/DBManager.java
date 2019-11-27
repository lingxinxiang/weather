package com.example.weather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public static SQLiteDatabase database;

    /* 初始化数据库信息*/
    public static void initDB(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    //查找数据库当中城市列表
    public static List<String> queryAllCityName() {
        Cursor cursor = database.query("info", null, null, null, null, null, null);
        List<String> cityList = new ArrayList<>();
        while (cursor.moveToNext()) {
            String city = cursor.getString(cursor.getColumnIndex("city"));
            cityList.add(city);
        }
        return cityList;
    }

    /*根据城市名称 替换信息内容*/
    public static int updateInfoByCity(String city, String content) {
        ContentValues values = new ContentValues();
        values.put("content", content);
        return database.update("info", values, "city=?", new String[]{city});
    }

    //新增一条城市记录
    public static long addCityInfo(String city, String content) {
        ContentValues values = new ContentValues();
        values.put("city", city);
        values.put("content", content);
        return database.insert("info", null, values);
    }

    //根据城市名 查寻数据库当中的内容
    public static String queryInfoByCity(String city) {
        Cursor cursor = database.query("info", null, "city?", new String[]{city}, null, null, null);
        if (cursor.getCount() > 0) {
            String content = cursor.getString(cursor.getColumnIndex("content"));
            return content;
        }
        return null;
    }

    /*
    存储城市天气要求最多5个城市消息  一旦超过5个城市就不能存储了 获取目前已经存储的数量*/
    public static int getCityCount() {
        Cursor cursor = database.query("info", null, null, null, null, null, null);
        int count = cursor.getCount();
        return count;
    }


}
