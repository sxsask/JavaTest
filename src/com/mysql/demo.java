package com.mysql;

import java.sql.*;

public class demo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://1.94.15.19:8083/Movie? characterEncoding=utf-8&useSSL=false", "root", "3100880856");
            if (conn == null) {
                System.out.println("连接失败");
            }
            System.out.println("连接成功 连接的数据库为" + conn.getCatalog());
            //创建建statement对象

            Statement stmt = conn.createStatement();
//            给movies这个表插入数据
       /*     String sql1 = "insert into movies (movieID, movieName, director, typeID, stardom, region, showtime, description, image, price) VALUES ( 21, '大话西游', '吴京', 1, '喜剧', '中国', '2019-01-01', '大话西游是一部喜','images/movies/JOHNQ.jpg',1231 );";
            int i1 = stmt.executeUpdate(sql1);
            if (i1 < 0) {
                System.out.println("插入失败");
            }
            System.out.println("插入成功");*/

            String sql1 = "insert into movies (movieID, movieName, director, typeID, stardom, region, showtime, description, image, price) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?,?,? );";
            PreparedStatement p1 = conn.prepareStatement(sql1);
            p1.setInt(1, 21);
            p1.setString(2, "大话西游");
            p1.setString(3, "吴京");
            p1.setInt(4, 1);
            p1.setString(5, "喜剧");
            p1.setString(6, "中国");
            p1.setString(7, "2019-01-01");
            p1.setString(8, "大话西游是一部喜");
            p1.setString(9, "images/movies/JOHNQ.jpg");
            p1.setInt(10, 1231);
            int i1 = p1.executeUpdate();
            if (i1 < 0) {
                System.out.println("插入失败");
            }
            System.out.println("插入成功");
             p1.close();

            //修改数据据
       /*     String sql2 = "update movies set movieName = '大话西游2' where movieID = 21;";//修改movies表中movieID为21的数据
            int i2 = stmt.executeUpdate(sql2);
            if (i2 < 0) {
                System.out.println("修改失败");
            }
            System.out.println("修改成功");*/


            String sql2 = "update movies set movieName = ? where movieID = ?;";
            PreparedStatement p2 = conn.prepareStatement(sql2);
            p2.setString(1, "大话西游2");
            p2.setInt(2, 21);
            int i2 = p2.executeUpdate();
            if (i2 < 0) {
                System.out.println("修改失败");
            }
            System.out.println("修改成功");
           p2.close();


            //查询数据
//            String sql3 = "select * from movies;";
//
//            ResultSet rs = stmt.executeQuery(sql3);
//            xh(rs);
//            rs.close();
            String sql3 = "select * from movies;";
            PreparedStatement p3 = conn.prepareStatement(sql3);
            ResultSet rs = p3.executeQuery();
            xh(rs);
            rs.close();


            //删除数据
          /*  String sql4 = "delete from movies where movieID = 21;";//删除movies表中movieID为21的数据
            int i3 = stmt.executeUpdate(sql4);
            if (i3 == 0) {
                System.out.println("删除失败");
            } else {
                System.out.println("删除成功");
            }
            ResultSet rr = stmt.executeQuery(sql3);
            xh(rr);
            rr.close();*/

            String sql4 = "delete from movies where movieID = ?;";
            PreparedStatement p4 = conn.prepareStatement(sql4);;
            p4.setInt(1, 21);
            int i3 = p4.executeUpdate();
            if (i3 == 0) {
                    System.out.println("删除失败");
                }
                System.out.println("删除成功");
               ResultSet rr = stmt.executeQuery(sql3);
                xh(rr);
                rr.close();

//            stmt.close();

            conn.close();


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("错误");
        }
    }


    private static void xh(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getString(3) + ":" + rs.getInt(4) + ":" + rs.getString(5) + ":" + rs.getString(6) + ":" + rs.getTime(7) + ":" + rs.getString(8) + ":" + rs.getString(9) + ":" + rs.getInt(10));
        }
    }
}
