package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        // int[] arr={101,34,119,1};
        // 创建一个有80000个随机值的数组
        int[] arr=new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*80000);//生成一个[0,80000)数
        }

        System.out.println("排序前");
        // System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("排序输出的时间是="+date1Str);

        selectSort(arr);

        System.out.println("排序后");
        // System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序输出的时间是="+date2Str);
    }

    //选择排序
    public static void selectSort(int[] arr){

        // 最终得到的程序
        //时间复杂度O(n^2)
        for (int j = 0; j < arr.length-1; j++) {

            int minIndex=j;
            int min=arr[j];
            for (int i = j+1; i <arr.length ; i++) {

                if(min>arr[i]){//说明假定的最小值并不是最小
                    min=arr[i];//重置min
                    minIndex=i;//重置minIndex
                }
            }

            // 将最小值，arr[0]，即交换
            if(minIndex!=j) {
                arr[minIndex] = arr[j];
                arr[j] = min;
            }

            /*System.out.println("第"+(j+1)+"轮后~~");
            System.out.println(Arrays.toString(arr));*/

        }


        //使用逐步推导的方式来推出选择排序的算法
        // 第一轮
        // 原始数组：101，34，119，1
        // 第一轮排序：1，24，119，101

        /*// 第1轮
        int minIndex=0;
        int min=arr[0];
        for (int i = 0+1; i <arr.length ; i++) {

            if(min>arr[i]){//说明假定的最小值并不是最小
                min=arr[i];//重置min
                minIndex=i;//重置minIndex
            }
        }

        // 将最小值，arr[0]，即交换
        if(minIndex!=0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }

        System.out.println("第一轮后~~");
        System.out.println(Arrays.toString(arr));

        // 第2轮
        minIndex=1;
        min=arr[1];
        for (int i = 1+1; i <arr.length ; i++) {

            if(min>arr[i]){//说明假定的最小值并不是最小
                min=arr[i];//重置min
                minIndex=i;//重置minIndex
            }
        }

        // 将最小值，arr[0]，即交换
        if (minIndex!=1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("第二轮后~~");
        System.out.println(Arrays.toString(arr));


        //第3轮
        minIndex=2;
        min=arr[2];
        for (int i = 2+1; i <arr.length ; i++) {

            if(min>arr[i]){//说明假定的最小值并不是最小
                min=arr[i];//重置min
                minIndex=i;//重置minIndex
            }
        }

        // 将最小值，arr[0]，即交换
        if (minIndex!=2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("第三轮后~~");
        System.out.println(Arrays.toString(arr));*/
    }

}
