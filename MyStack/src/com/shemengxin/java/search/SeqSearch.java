package com.shemengxin.java.search;

/**
 * 线性查找
 */
public class SeqSearch {

    public static void main(String[] args) {

        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = sqlSearch(arr,-11);
        if(index==-1){

            System.out.println("没有找到");

        } else {

            System.out.println("找到，下标为="+index);

        }

    }

    /**
     * 这里我们实现的线性查找是找到一个满足条件的值，就返回
     * @param arr
     * @param value
     * @return
     */
    public static int sqlSearch(int[] arr, int value) {

        //线性查找是逐一对比，发现有相同值就返回下标
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {

                return i;

            }

        }
        return -1;

    }

}
