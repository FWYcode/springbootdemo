//package com.tset;
//
//import com.mysql.cj.jdbc.ConnectionGroupManager;
//import org.apache.ibatis.jdbc.SQL;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Administrator on 2019/4/24 0024.
// */
//public class DbTest {
//    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?serverTimezone=GMT%2B8", "root", "123456");
//        Statement statement = con.createStatement();
//        String sql = "select * from tb_item";
//        ResultSet resultSet = statement.executeQuery(sql);
//        List<String> names = new ArrayList<String>();
//        while (resultSet.next()) {
//            String name = resultSet.getString("title");
//            names.add(name);
//
//        }
//        System.out.println(names);
//        System.out.println(names.size());
//
//
//
//    }
//}
