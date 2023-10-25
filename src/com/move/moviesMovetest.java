package com.move;

import java.util.List;
import java.util.Scanner;

public class moviesMovetest {
    public static void main(String[] args) {

        tou:
        while (true) {
            int print = print();
            switch (print) {
                case 1:
                    insert();
                    break;
                case 2:
                    select();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    //根据id查找数据
                    getMoveById();
                    break;
                case 6:
                    System.exit(0);
                default://
                    System.out.println("输入错误,请重新输入");
            }
        }


    }

    //根据id查找数据
    private static void getMoveById() {
        System.out.println("请输入要查询的电影id");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt() == false) {
            System.out.println("输入的不是整数");
        }
        int a = sc.nextInt();
        MoveDaoimpl moveDao = new MoveDaoimpl();
        List<Move> moveById = moveDao.getMoveById(a);
        System.out.println(moveById);

    }
    //修改数据
    private static void update() {
        System.out.println("请输入要修改的电影id");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt() == false) {
            System.out.println("输入的不是整数");
        }
        int a = sc.nextInt();
        System.out.println("请输入要修改的电影名称");
        String movename = sc.next();
        System.out.println("请输入要修改的电影导演");
        String director = sc.next();
        MoveDaoimpl moveDao = new MoveDaoimpl();
        String typeid = null;
        loop2:
        while (true) {
            System.out.println("请输入电影类型,1-喜剧，2-爱情，3-动作");
            typeid = sc.next();
            if (!((typeid.equals("1") || typeid.equals("2") || typeid.equals("3")))) {
                System.out.println("输入的不是整数，请重新输入");
            }else {
                break loop2;
            }

        }
        System.out.println("请输入要修改的电影明星");
        String stardom = sc.next();
        System.out.println("请输入要修改的电影地区");
        String region = sc.next();
        String showtime = null;
        loop1:
        while (true) {
            System.out.println("请输入输入电影上映时间");
            showtime = sc.next();
            //判断是不是是不是时间格式
            //判断是不是时间格式
            boolean matches = showtime.matches("\\d{4}:\\d{2}:\\d{2}");
            if (!(matches)) {
                System.out.println(" 输入的不是时间格式");
            }else {
                break loop1;
            }
        }
        System.out.println("请输入要修改的电影描述");
        String description = sc.next();
        System.out.println("请输入要修改的电影图片");
        String image = sc.next();
        System.out.println("请输入要修改的电影价格");
        String price = sc.next();
        Move move = new Move(a, movename, director, typeid, stardom, region, showtime, description, image, price);
        int i = moveDao.updateMove(move);
        if (i == 0) {
            System.out.println("修改失败");
        } else {
            System.out.println("修改成功");
        }
    }


    //删除数据
    private static void delete() {

        System.out.println("请输入要删除的电影id");
        Scanner sc = new Scanner(System.in);
        //判断anint是不是整数
        if (sc.hasNextInt() == false) {
            System.out.println("输入的不是整数");
        }
        int a = sc.nextInt();
        MoveDaoimpl moveDao = new MoveDaoimpl();
        int i = moveDao.deleteMove(a);
        if (a == 0) {
            System.out.println("删除失败");
        } else {
            System.out.println("删除成功");
        }
    }


    //查询数据
    private static void select() {
        MoveDaoimpl moveDao = new MoveDaoimpl();
        List<Move> allMoves = moveDao.getAllMoves();
        for (Move move : allMoves) {
            System.out.println(move.getMovieid() + "|" + move.getMoviename() + "|" + move.getDirector() + "|" + move.getTypeid() + "|" + move.getStardom() + "|" + move.getRegion() + "|" + move.getShowtime() + "|" + move.getDescription() + "|" + move.getImage() + "|" + move.getPrice());
        }
    }


    //插入数据
    private static void insert() {
        Move move = new Move();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入电影名称");
        String movename = sc.next();
        System.out.println("请输入输入导演");
        String director = sc.next();
        String typeid = null;
        loop:
        while (true) {
            System.out.println("请输入电影类型,1-喜剧，2-爱情，3-动作");
            typeid = sc.next();
            if (!((typeid.equals("1") || typeid.equals("2") || typeid.equals("3")))) {
                System.out.println("输入的不是整数，请重新输入");
            }else {
                break loop;
            }

        }
        System.out.println("请输入电影明星");
        String stardom = sc.next();
        System.out.println("请输入电影地区");
        String region = sc.next();
        String showtime = null;
        loop1:
        while (true) {
            System.out.println("请输入输入电影上映时间");
            showtime = sc.next();
            //判断是不是时间格式
            boolean matches = showtime.matches("\\d{4}:\\d{2}:\\d{2}");
            if (!(matches)) {
                System.out.println(" 输入的不是时间格式");
            }else {
                break loop1;
            }

        }
        System.out.println("请输入电影描述");
        String description = sc.next();
        System.out.println("请输入电影图片");
        String image = sc.next();
        System.out.println("请输入电影价格");
        String price = sc.next();
        move.setMoviename(movename);
        move.setDirector(director);
        move.setTypeid(typeid);
        move.setStardom(stardom);
        move.setRegion(region);
        move.setShowtime(showtime);
        move.setDescription(description);
        move.setImage(image);
        move.setPrice(price);
        MoveDaoimpl moveDao = new MoveDaoimpl();
        int i = moveDao.addMove(move);
        if (i == 0) {
            System.out.println("插入失败");
        } else {
            System.out.println("插入成功");
        }
    }

    //打印信息
    public static int print() {
        System.out.println("请选择操作:1插入数据,2查询数据，3删除数据 4修改数据5根据id查找 6退出");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt() == false)///判断是否为整数
        {
            System.out.println("输入有误");
            return 0;
        }
        int a = sc.nextInt();
        return a;
    }

}
