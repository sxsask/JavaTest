package com.EmployeeManager.emp;

import com.EmployeeManager.dept.Dept;
import com.EmployeeManager.dept.DeptDaoimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpTest {
    public static void start(String[] args) {
        EmpDaoimpl empDaoimpl = new EmpDaoimpl();
        while (true) {
            int i = printHeader();
            switch (i) {
                case 1:
                    addEmp();
                    break;
                case 2:
                    updateEmp();
                    break;
                case 3:
                    deleteEmp();
                    break;
                case 4:
                    getAllEmps();
                    break;
                case 5:
                    getEmpById();
                    break;
                case 6:
                    getEmpByCondition();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误");
            }
        }

    }

    //多条件查询
    public static void getEmpByCondition() {
        Integer dept = null;
        String job = null;
        String hiredate = null;
        String hiredate1 = null;
        String sal = null;
        String sal1 = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("是否根据员工所在部门多条查询 y/n");
        String isDept = sc.next();
        if (isDept.equalsIgnoreCase("y")) {
            System.out.println("10,教研部,北京\n" + "20,学工部,上海\n" + "30,销售部,广州\n" + "40,财务部,武汉\n");
            System.out.println("请输入部门id");
            dept = sc.nextInt();
        }
        System.out.println("是否根据工作职位进行多条件查询 y/n");
        String isJob = sc.next();
        if (isJob.equalsIgnoreCase("y")) {
            System.out.println("请输入工作职位名称");
            job = sc.next();
        }
        System.out.println("是否根据入职时间进行查询 y/n");
        String isHiredate = sc.next();
        if (isHiredate.equalsIgnoreCase("y")) {
            System.out.println("请输入入职开始时间");
            hiredate = sc.next();
            System.out.println("请输入入职结束时间");
            hiredate1 += " " + sc.next();
        }
        System.out.println("是否根据薪水范围进行查询 y/n");
        String isSal = sc.next();
        if (isSal.equalsIgnoreCase("y")) {
            System.out.println("请输入薪水开始范围");
            sal = sc.next();
            System.out.println("请输入薪水结束范围");
            sal1 = sc.next();
        }
        EmpDaoimpl empDaoimpl = new EmpDaoimpl();
        List<Emp> allEmps = empDaoimpl.getEmpByCondition(name, dept, job, hiredate,hiredate1, sal,sal1);
        if (allEmps.size() == 0) {
            System.out.println("没有查询到结果");
            return;
        } else {
            System.out.println("编号\t姓名\t所在部门\t工作\t上级领导\t入职时间\t薪水\t奖金");
            for (Emp emp : allEmps) {
                System.out.println(emp.getEmpno() + "\t" + emp.getEname() + "\t" + emp.dept.getDname() + "\t" + emp.getJob() + "\t" + emp.getMgr() + "\t" + emp.getHiredate() + "\t" + emp.getSal() + "\t" + emp.getComm());
            }
        }

    }

    //根据id查询职员信息
    public static void getEmpById() {
        System.out.println("请输入职员id");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt() == false) {
            System.out.println("输入的不是数字");
        } else {
            int id = sc.nextInt();
            EmpDaoimpl empDaoimpl = new EmpDaoimpl();
            List<Emp> allEmps = empDaoimpl.getById(id);
            System.out.println("编号\t姓名\t所在部门\t工作\t上级领导\t入职时间\t薪水\t奖金");
            for (Emp emp : allEmps) {
                System.out.println(emp.getEmpno() + "\t" + emp.getEname() + "\t" + emp.dept.getDname() + "\t" + emp.getJob() + "\t" + emp.getMgr() + "\t" + emp.getHiredate() + "\t" + emp.getSal() + "\t " + emp.getComm());
            }

        }

    }

    //查询所有信息
    public static void getAllEmps() {
        EmpDaoimpl empDaoimpl = new EmpDaoimpl();
        List<Emp> allEmps = empDaoimpl.getAllEmps();
        System.out.println("编号\t姓名\t所在部门\t工作\t上级领导\t入职时间\t薪水\t奖金");
        for (Emp emp : allEmps) {
            System.out.println(emp.getEmpno() + "\t" + emp.getEname() + "\t" + emp.dept.getDname() + "\t" + emp.getJob() + "\t" + emp.getMgr() + "\t" + emp.getHiredate() + "\t" + emp.getSal() + "\t " + emp.getComm());
        }
    }

    //删除方法
    public static void deleteEmp() {

        System.out.println("请输入职员编号");
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            System.out.println("输入的不是数字");
        }
        int id = sc.nextInt();
        EmpDaoimpl empDaoimpl = new EmpDaoimpl();
        boolean existId = empDaoimpl.isExistId(id);
        if (existId == false) {
            System.out.println("该职员不存在");
            return;
        }
        int i = empDaoimpl.deleteEmp(id);
        if (i == 0) {
            System.out.println("删除失败");
        } else {
            System.out.println("删除成功");
        }
    }

    //修改方法
    public static void updateEmp() {
        Integer id = null;
        Integer mgr = null;
        Double sal = null;
        Double comm = null;
        String job = null;
        Emp emp = new Emp();
        Scanner sc = null;
        while (true) {
            System.out.println("请输入职员id");
            sc = new Scanner(System.in);
            if (sc.hasNextInt() == false) {
                System.out.println("输入的不是数字 重新输入");
            } else {
                id = sc.nextInt();
                emp.setEmpno(id);
                break;
            }
        }
        sc.nextLine();
        //判断断该职员是否存在
        EmpDaoimpl empDaoimpl = new EmpDaoimpl();
        boolean existId = empDaoimpl.isExistId(id);
        if (existId == false) {
            System.out.println("该职员不存在");
            return;
        }
        System.out.println("是否修改职员姓名 输入n不修改");
        String name = sc.nextLine();
        if (name.equals("n")) {
            name = null;
        } else {
            emp.setEname(name);
        }
        System.out.println("是否修改职员工作 输入n不修改");
        String job1 = sc.next();
        if (job1.equalsIgnoreCase("n")) {
            job = null;
        } else {
            job = job1;
            emp.setJob(job);

        }
        while (true) {
            System.out.println("是否修改职员上级领导 输入n不修改");
            String input = sc.next(); // 使用next()方法获取用户输入
            if (input.equalsIgnoreCase("n")) {
                mgr = null;
                break;
            }
            if (input.matches("\\d+")) { // 使用正则表达式检查是否为数字
                mgr = Integer.parseInt(input);// 转换为整型
                emp.setMgr(mgr);
                break;
            } else {
                System.out.println("输入的不是数字，请重新输入");
            }
        }
        while (true) {
            System.out.println("是否修改职员薪水 输入n不修改");
            String input = sc.next();
            if (input.equalsIgnoreCase("n")) {
                sal = null;
                break;
            }
            //判断是不是Double


            if (input.matches("\\d+(\\.\\d+)?")) {
                sal = Double.parseDouble(input);
                emp.setSal(sal);
                break;
            } else {
                System.out.println("输入的不是数字 重新输入");
            }
        }

        while (true) {
            System.out.println("是否修改职员提成 输入n不修改");
            String input = sc.next();
            if (input.equalsIgnoreCase("n")) {
                comm = null;
                break;
            }
            if (input.matches("\\d+(\\.\\d+)?")) {
                comm = Double.parseDouble(input);
                emp.setComm(comm);
                break;
            } else {
                System.out.println("输入的不是数字 重新输入");
            }
        }


        int i = empDaoimpl.updateEmp(emp);
        if (i == 0) {
            System.out.println("修改失败");
        } else {
            System.out.println("修改成功");
        }

    }


    //添加方法
    public static void addEmp() {
        Dept dept  = new Dept();
        EmpDaoimpl empDaoimpl = new EmpDaoimpl();
        Scanner sc = new Scanner(System.in);
        String name;
        Integer mgr;
        double sal;
        double comm;
        int deptNo;
        while (true) {
            System.out.println("请输入员工姓名");
            name = sc.next();
            boolean b = empDaoimpl.isExistName(name);
            if (b == false) {
                break;
            }
            System.out.println("该员工已存在");

        }
        while (true) {

            System.out.println("请输入员工所在部门名称id");
            int deptno = sc.nextInt();
            //判断部门是否存在
            DeptDaoimpl deptDaoimpl = new DeptDaoimpl();
              boolean existName = deptDaoimpl.isExistdeptno(deptno);
          if(existName==false){
              System.out.println("该部门不存在");
          }else {
              dept.setDeptno(deptno);
              break;
          }

        }
        System.out.println("请输入员工工作");
        String job = sc.next();
        while (true) {
            System.out.println("请输入上级领导id");
            Scanner sc1 = new Scanner(System.in);
            if (sc1.hasNextInt() == false) {
                System.out.println("输入的不是数字 重新输入");
            } else {
                mgr = sc1.nextInt();
                break;
            }

        }


        //获取当前时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
        Date date = new Date(System.currentTimeMillis());
        String format = formatter.format(date);
        while (true) {
            System.out.println("请输入员工薪水");
            Scanner sc2 = new Scanner(System.in);
            if (sc2.hasNextDouble() == false) {
                System.out.println("输入的不是数字 重新输入");
            } else {
                sal = sc2.nextDouble();
                break;
            }
        }


        while (true) {
            System.out.println("请输入员工奖金");
            Scanner sc3 = new Scanner(System.in);
            if (sc3.hasNextDouble() == false) {
                System.out.println("输入的不是数字 重新输入");
            } else {
                comm = sc3.nextInt();
                break;
            }
        }
        Emp emp = new Emp(name, job, mgr, format, sal, comm, dept);
        int i = empDaoimpl.addEmp(emp);
        if (i == 0) {
            System.out.println("添加失败");
        }
        System.out.println("添加成功");
        System.out.println("添加时间" + format);
    }


    //打印表头信息

    public static int printHeader() {

        System.out.println("1,添加职员信息 2,修改职员信息 3,删除职员信息 4,查询所有职员信息 5,根据部门id查询职员信息 6,多条件查询职员信息 7,退出系统");
        System.out.println("请选择你要执行的功能");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt() == false) {
            System.out.println("输入有误");
            return 0;
        }
        int i = sc.nextInt();
        return i;
    }

}
