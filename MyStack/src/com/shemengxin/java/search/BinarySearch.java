package com.shemengxin.java.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二分查找
 * <p>
 * 注意：使用二分查找的前提是该数组是有序的。
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        /*int resIndex = binarySearch(arr, 0, arr.length, 89);
        System.out.println("resIndex=" + resIndex);*/

        ArrayList<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(resIndexList);
    }

    //二分查找

    /**
     * 此二分查找只查找出数组中第一个匹配的元素下标
     *
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        if (left > right) {

            return -1;

        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {//向右递归

            return binarySearch(arr, mid + 1, right, findVal);

        } else if (findVal < midVal) {//向左递归

            return binarySearch(arr, left, mid - 1, findVal);

        } else {

            return mid;

        }

    }

    /**
     * 此方法查询出数组中所有匹配元素的下标
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        if (left > right) {

            return new ArrayList<Integer>();

        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {//向右递归

            return binarySearch2(arr, mid + 1, right, findVal);

        } else if (findVal < midVal) {//向左递归

            return binarySearch2(arr, left, mid - 1, findVal);

        } else {

            ArrayList<Integer> resList = new ArrayList<Integer>();
            //向左扫描
            int temp = mid - 1;
            while (true) {

                if (temp < 0 || arr[temp] != findVal) {

                    break;

                }

                //否者，就将temp放入到resIndexList
                resList.add(temp);
                temp -= 1;

            }
            resList.add(mid);

            //向右扫描
            temp = mid + 1;
            while (true) {

                if (temp > arr.length - 1 || arr[temp] != findVal) {

                    break;

                }

                //否者，就将temp放入到resIndexList
                resList.add(temp);
                temp += 1;

            }
            return resList;

        }

    }

}


