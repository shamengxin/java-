package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

    public static void main(String[] args) {

        // int[] arr = {-9, 78, 0, 23, -567, 70};
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

        quickSort(arr,0,arr.length-1);

        System.out.println("排序后");
        // System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序输出的时间是="+date2Str);
    }

    public static void quickSort(int[] arr, int left, int right) {

        int l = left;//左下标
        int r = right;//右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;//临时变量
        //while循环的目的是让比pivot小的值放到左边，
        //比pivot大的值放到右边
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot的值，才退出
            while (arr[l] < pivot) {

                l += 1;

            }
            //在pivot的右边一直找，找到小于等于pivot的值，才退出
            while (arr[r] > pivot) {

                r -= 1;

            }
            //如果l >= r说明pivot 的左右两边的值，已经按照
            // 左边全部都是小于等于pivot值，右边全部都是大于等于pivot值
            if (l >= r) {

                break;

            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot
            if (arr[l] == pivot) {

                r -= 1;

            }
            //如果交换完后，发现这个arr[r] == pivot
            if (arr[r] == pivot) {

                l += 1;

            }

        }
        //如果l==r,必须l++,r--,否则为出现栈溢出
            if(l==r){

                l+=1;
                r-=1;

            }

        //向左递归
        if(left <r){

            quickSort(arr,left,r);

        }

        if (right>l){

            quickSort(arr,l,right);

        }

    }

}
