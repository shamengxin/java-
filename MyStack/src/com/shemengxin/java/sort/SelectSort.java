package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ѡ������
 */
public class SelectSort {

    public static void main(String[] args) {
        // int[] arr={101,34,119,1};
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

        selectSort(arr);

        System.out.println("�����");
        // System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("���������ʱ����="+date2Str);
    }

    //ѡ������
    public static void selectSort(int[] arr){

        // ���յõ��ĳ���
        //ʱ�临�Ӷ�O(n^2)
        for (int j = 0; j < arr.length-1; j++) {

            int minIndex=j;
            int min=arr[j];
            for (int i = j+1; i <arr.length ; i++) {

                if(min>arr[i]){//˵���ٶ�����Сֵ��������С
                    min=arr[i];//����min
                    minIndex=i;//����minIndex
                }
            }

            // ����Сֵ��arr[0]��������
            if(minIndex!=j) {
                arr[minIndex] = arr[j];
                arr[j] = min;
            }

            /*System.out.println("��"+(j+1)+"�ֺ�~~");
            System.out.println(Arrays.toString(arr));*/

        }


        //ʹ�����Ƶ��ķ�ʽ���Ƴ�ѡ��������㷨
        // ��һ��
        // ԭʼ���飺101��34��119��1
        // ��һ������1��24��119��101

        /*// ��1��
        int minIndex=0;
        int min=arr[0];
        for (int i = 0+1; i <arr.length ; i++) {

            if(min>arr[i]){//˵���ٶ�����Сֵ��������С
                min=arr[i];//����min
                minIndex=i;//����minIndex
            }
        }

        // ����Сֵ��arr[0]��������
        if(minIndex!=0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }

        System.out.println("��һ�ֺ�~~");
        System.out.println(Arrays.toString(arr));

        // ��2��
        minIndex=1;
        min=arr[1];
        for (int i = 1+1; i <arr.length ; i++) {

            if(min>arr[i]){//˵���ٶ�����Сֵ��������С
                min=arr[i];//����min
                minIndex=i;//����minIndex
            }
        }

        // ����Сֵ��arr[0]��������
        if (minIndex!=1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("�ڶ��ֺ�~~");
        System.out.println(Arrays.toString(arr));


        //��3��
        minIndex=2;
        min=arr[2];
        for (int i = 2+1; i <arr.length ; i++) {

            if(min>arr[i]){//˵���ٶ�����Сֵ��������С
                min=arr[i];//����min
                minIndex=i;//����minIndex
            }
        }

        // ����Сֵ��arr[0]��������
        if (minIndex!=2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("�����ֺ�~~");
        System.out.println(Arrays.toString(arr));*/
    }

}
