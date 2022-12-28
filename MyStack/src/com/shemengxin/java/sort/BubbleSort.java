package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class BubbleSort {
    public static void main(String[] args) {
        // int[] arr={3,9,-1,10,-2};

        // ����һ��ð��������ٶ�O��n^2��,��80000�����ݣ�����
        // ����һ����80000�����ֵ������
        int[] arr=new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*80000);//����һ��[0,80000)��
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("���������ʱ����="+date1Str);
        //����ð������
        bubbleSort(arr);


        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("���������ʱ����="+date2Str);
        // System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int arr[]){
        int temp=0;//��ʱ����
        boolean flag=false;//�Ż�
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

            if (!flag){//��һ�������У�һ�ν�����û�з�����
                break;
            }else {
                flag=false;//����flag��������һ���ж�
            }
        }
    }
}
