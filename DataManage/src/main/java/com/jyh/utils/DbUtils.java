package com.jyh.utils;

import com.alibaba.fastjson2.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {
    public static Connection createconnection(String url,String username,String password,String driver){
        Connection conn=null;
        try{
            Class.forName(driver);
            //连接数据库
            conn= DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
            return null;
        }
        return conn;
    }
    //查询某个数据库的db用的
    public static List<Map<String, String>> gets(String url,String username,String password,String driver) {
        List<Map<String,String>> dbList=new ArrayList<>();
        try {
            Connection connection = createconnection(url,username, password,driver);
            Statement stmt = connection.createStatement();
            String sql = "show databases";
            ResultSet resultSet = stmt.executeQuery(sql);
//            2.ResultSet对象保持一个光标指向其当前的数据行，最开始光标在第一行。
            while (resultSet.next()) {
                Map<String, String> tableMap = new HashMap<>();
                tableMap.put("key", resultSet.getString(1));
                tableMap.put("value", resultSet.getString(1));
                dbList.add(tableMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取db信息失败");
        }
        return dbList;
    }
    //查询某个db的table用的,传入的url要带 database
    public static List<Map<String, String>> gettableList(String url,String username,String password,String driver) {
        List<Map<String,String>> dbList=new ArrayList<>();
        try {
            Connection connection = createconnection(url,username, password,driver);
            Statement stmt = connection.createStatement();
            String sql = "show tables";
            ResultSet resultSet = stmt.executeQuery(sql);
//            2.ResultSet对象保持一个光标指向其当前的数据行，最开始光标在第一行。
            while (resultSet.next()) {
                Map<String, String> tableMap = new HashMap<>();
                tableMap.put("key", resultSet.getString(1));
                tableMap.put("value", resultSet.getString(1));
                dbList.add(tableMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取db信息失败");
        }
        return dbList;
    }

    public static void main(String[] args) {
        List<Map<String, String>> list = gettableList("jdbc:mysql://192.168.111.207:3306/DataZhongTai", "root", "123456", "com.mysql.jdbc.Driver");
//        toJSONString(Object)【将指定的对象序列化成Json表示形式】
        System.out.println(JSONObject.toJSONString(list));
    }



}
