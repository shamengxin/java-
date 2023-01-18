package com.shemengxin.java.search;

import java.util.Arrays;

/**
 * 插值查找
 */
public class InsertValue {

    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i <100; i++) {

            arr[i]= i+1;

        }

        int index = insertValueSearch(arr,0,arr.length-1,89);
        System.out.println(index);

    }

    //编写插值查找算法
    /**
     * 此算法需要数组是有序的
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 查找值
     * @return
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){

        //后面两个判断是必须要的，因为finVal这个值参与了mid的运算，如果findVal这个值特别大的话，会
        //导致mid也很大，从而导致数组越界。
        if(left>right || findVal<arr[0] || findVal>arr[arr.length-1]){

            return -1;

        }

        //求出mid
        int mid = left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];
        if(findVal>midVal){//向右递归

            return insertValueSearch(arr,mid+1,right,findVal);

        } else if (findVal < midVal) {//向左递归

            return insertValueSearch(arr,left,mid-1,findVal);

        }else{

            return mid;

        }

    }

}
