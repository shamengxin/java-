package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class BubbleSort {
    public static void main(String[] args) {
        // int[] arr={3,9,-1,10,-2};

        // 测试一下冒泡排序的速度O（n^2）,给80000个数据，测试
        // 创建一个有80000个随机值的数组
        int[] arr=new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*80000);//生成一个[0,80000)数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("排序输出的时间是="+date1Str);
        //测试冒泡排序
        bubbleSort(arr);


        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序输出的时间是="+date2Str);
        // System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int arr[]){
        int temp=0;//临时变量
        boolean flag=false;//优化
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

            if (!flag){//在一趟排序中，一次交换都没有发生过
                break;
            }else {
                flag=false;//重置flag，进行下一次判断
            }
        }
    }
}
