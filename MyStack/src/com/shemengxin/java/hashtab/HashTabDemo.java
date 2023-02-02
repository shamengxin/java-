package com.shemengxin.java.hashtab;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.Scanner;

/**
 * ��һ����˾�������µ�Ա��������ʱ��Ҫ�󽫸�Ա������Ϣ���루id���Ա����䣬���֣�סַ����������
 * �������Ա����idʱ��Ҫ����ҵ���Ա����������Ϣ��
 * Ҫ��
 *      ��ʹ�����ݿ⣬�ٶ�Խ��Խ��=>��ϣ��ɢ�У�
 */
public class HashTabDemo {
    public static void main(String[] args) {

        //������ϣ��
        HashTab hashTab = new HashTab(7);

        //дһ���򵥲˵�
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:��ӹ�Ա");
            System.out.println("list:��ʾ��Ա");
            System.out.println("find:���ҹ�Ա");
            System.out.println("exit:�˳�ϵͳ");

            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("����id");
                    int id=scanner.nextInt();
                    System.out.println("��������");
                    String  name= scanner.next();
                    //������Ա
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("����id");
                    id=scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("��������");
            }
        }
    }
}
