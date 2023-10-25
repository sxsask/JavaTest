package com.EmployeeManager;

import com.EmployeeManager.dept.DeptTest;
import com.EmployeeManager.emp.EmpTest;

import java.util.Scanner;

public class EmployeeManagerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeptTest deptTest = new DeptTest();
        EmpTest empTest = new EmpTest();
        while (true) {
            System.out.println("请选择需要操作的表1.员工表2.部门表");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    empTest.start(args);
                    break;
                case 2:
                    deptTest.start(args);
                    break;
                default:
                    System.out.println("输入有误");
            }
        }

    }
}
