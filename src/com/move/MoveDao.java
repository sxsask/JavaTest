package com.move;

import java.util.List;

public interface  MoveDao  {

    //插入数据
    public int addMove(Move move);

    //删除数据
    public int deleteMove(int moveid);

    //修改数据
    public int updateMove(Move move);

    //查询数据
    public List<Move> getAllMoves();

    //根据id查找数据
    public List<Move> getMoveById(int moveid);
}
