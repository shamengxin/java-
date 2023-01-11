package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

    public static void main(String[] args) {

        // int[] arr = {101, 34, 119, 1};

        // ����һ����80000�����ֵ������
        int[] arr=new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*80000);//����һ��[0,80000)��
        }

        System.out.println("����ǰ");
        // System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("���������ʱ����="+date1Str);

        insertSort(arr);

        System.out.println("�����");
        // System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("���������ʱ����="+date2Str);

    }

    //��������
    public static void insertSort(int[] arr) {

        int insertVal=0;
        int insertIndex=0;
        //ʹ��forѭ�����д����
        for (int i = 1; i < arr.length; i++) {

            //������������
            insertVal = arr[i];
            //��arr[1]��ǰ����������±�
            insertIndex = i - 1;

            //��insertVal�ҵ������λ��
            //1.insertIndex>=0��֤�ڸ�insertVal �Ҳ���λ��ʱ����Խ��
            //2.insertVal < arr[insertIndex] �������������û���ҵ�����λ��
            //3.����Ҫ��arr[insertIndex] ����
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;

            }
            //���˳�whileѭ��ʱ��˵�������λ���ҵ���insertIndex+1
            if(i!=(insertIndex+1)) {
                arr[insertIndex + 1] = insertVal;
            }
            // System.out.println("��"+i+"�ֲ��룺");
            // System.out.println(Arrays.toString(arr));

        }

        //ʹ�����Ƶ��ķ�ʽ��д
        //��1��{101,34,119,1}==��{34��101,119,1}

        /*//������������
        int insertVal = arr[1];
        //��arr[1]��ǰ����������±�
        int insertIndex = 1 - 1;

        //��insertVal�ҵ������λ��
        //1.insertIndex>=0��֤�ڸ�insertVal �Ҳ���λ��ʱ����Խ��
        //2.insertVal < arr[insertIndex] �������������û���ҵ�����λ��
        //3.����Ҫ��arr[insertIndex] ����
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;

        }
        //���˳�whileѭ��ʱ��˵�������λ���ҵ���insertIndex+1
        arr[insertIndex + 1] = insertVal;

        System.out.println("��1�ֲ��룺");
        System.out.println(Arrays.toString(arr));

        //��2�֣�
        insertVal = arr[2];
        insertIndex = 2 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;

        }
        arr[insertIndex + 1] = insertVal;

        System.out.println("��2�ֲ��룺");
        System.out.println(Arrays.toString(arr));

        //��3�֣�
        insertVal = arr[3];
        insertIndex = 3 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;

        }
        arr[insertIndex + 1] = insertVal;

        System.out.println("��3�ֲ��룺");
        System.out.println(Arrays.toString(arr));*/
    }

}
