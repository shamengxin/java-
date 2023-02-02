package com.shemengxin.java.hashtab;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.Scanner;

/**
 * 有一个公司，当有新的员工来报道时，要求将该员工的信息加入（id，性别，年龄，名字，住址。。。），
 * 当输入该员工的id时，要求查找到该员工的所有信息。
 * 要求：
 *      不使用数据库，速度越快越好=>哈希表（散列）
 */
public class HashTabDemo {
    public static void main(String[] args) {

        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");

            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入名字");
                    String  name= scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入id");
                    id=scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("输入有误");
            }
        }
    }
}
