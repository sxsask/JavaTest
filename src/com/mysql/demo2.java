package com.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class demo2 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://1.94.15.19:8083/test?characterEncoding=utf-8&useSSL=false", "root", "3100880856");
        if (conn == null) {
            System.out.println("连接失败");
        } else {
            System.out.println("连接成功 连接的数据库为" + conn.getCatalog());
        }

        try {

            //开启事务
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            //判断有没有test这个表
            String sql1 = "show tables like 'test'";
            ResultSet resultSet = stmt.executeQuery(sql1);
            boolean next = resultSet.next();
            if (next == false) {
                //新建test这个表
                String sql3 = "create table test(id int, name varchar(20))";
                stmt.executeUpdate(sql3);
                System.out.println("创建成功");
            }
            String sql2 = "insert into test values(1,'张三')";
            conn.createStatement().executeUpdate(sql2);
            System.out.println("插入成功");


            String sql = "select * from test ";
            ResultSet resultSet1 = stmt.executeQuery(sql);
            //输出数据
            List<test> tste =new ArrayList<>();
            while (resultSet1.next()) {
                test test = new test();
                test.setId(resultSet1.getInt("id"));
                test.setName(resultSet1.getString("name"));
                tste.add(test);
            }
            System.out.println(tste);
            resultSet1.close();
            System.out.println("查询成功");


            conn.commit();

        } catch (Exception e) {
            System.out.println("回滚");
            //回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }
    }
}
