package com.move;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoveDaoimpl extends BaseDao implements MoveDao{




    //插入数据
    public int addMove(Move move) {
        int count = 0;
        try {

            super.getConnection();
            String sql = "insert into movies(moviename,director,typeid,stardom,region,showtime,description,image,price) values(?,?,?,?,?,?,?,?,?)";

            getmovies(move, sql);

            count = pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            super.closeAll();
        }

        return count;
    }

    //删除数据
    public int deleteMove(int moveid) {
        int count = 0;
        try {
            super.getConnection();
            String sql = "delete from movies where movieid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, moveid);
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            super.closeAll();
        }
        return count;
    }

    //查询数据
    public List<Move> getAllMoves() {
        List<Move> list = new ArrayList<>();

        try {
            super.getConnection();
            String sql = "select * from movies";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Move move = new Move();
                move.setMovieid(rs.getInt("movieid"));
                move.setMoviename(rs.getString("moviename"));
                move.setDirector(rs.getString("director"));
                move.setTypeid(rs.getString("typeid"));
                move.setStardom(rs.getString("stardom"));
                move.setRegion(rs.getString("region"));
                move.setShowtime(rs.getString("showtime"));
                move.setDescription(rs.getString("description"));
                move.setImage(rs.getString("image"));
                move.setPrice(rs.getString("price"));
                list.add(move);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public List<Move> getMoveById(int moveid) {
        List <Move> list = new ArrayList<>();

        try {
            super.getConnection();
            String sql = "select * from movies where movieid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, moveid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Move move = new Move();
                move.setMovieid(rs.getInt("movieid"));
                move.setMoviename(rs.getString("moviename"));
                move.setDirector(rs.getString("director"));
                move.setTypeid(rs.getString("typeid"));
                move.setStardom(rs.getString("stardom"));
                move.setRegion(rs.getString("region"));
                move.setShowtime(rs.getString("showtime"));
                move.setDescription(rs.getString("description"));
                move.setImage(rs.getString("image"));
                move.setPrice(rs.getString("price"));
                list.add(move);
                return list;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    //修改数据
    public int updateMove(Move move) {
        int count = 0;

        try {
            super.getConnection();
            String sql = "update movies set moviename=?,director=?,typeid=?,stardom=?,region=?,showtime=?,description=?,image=?,price=? where movieid=?";
            getmovies(move, sql);
            pstmt.setInt(10, move.getMovieid());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    private void getmovies(Move move, String sql) throws SQLException {
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, move.getMoviename());
        pstmt.setString(2, move.getDirector());
        pstmt.setString(3, move.getTypeid());
        pstmt.setString(4, move.getStardom());
        pstmt.setString(5, move.getRegion());
        pstmt.setString(6, move.getShowtime());
        pstmt.setString(7, move.getDescription());
        pstmt.setString(8, move.getImage());
        pstmt.setString(9, move.getPrice());
    }
}
