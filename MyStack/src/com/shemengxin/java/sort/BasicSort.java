package com.shemengxin.java.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class BasicSort {
    public static void main(String[] args) {
        int[] arrays=new int[]{53,542,3,63,14,214,154,748,616};

        sort(arrays);
    }

    /**
     * 1.获取原序列的最大位多少
     * @param arrays
     */
    public static void sort(int[] arrays){

        /**
         * 获取最大位数
         */
        int max=0;
        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i]>max){
                max=arrays[i];
            }
        }
        /**
         * 获取字符串长度，所以把int类型转换成字符串类型
         */
        int maxLength=(max+"").length();

        /**
         * 定义二维数组，大小10，表示10个桶，每一个桶则是一个数组
         * [[],[],[],[],....]
         */
        int[][] bucket=new int[10][arrays.length];
        /**
         * 辅助数组
         */
        int[] bucketElementCount=new int[10];

        /**
         * 判断个位
         */
        for (int i = 0; i < arrays.length; i++) {
            int locationElement=arrays[i]/1%10;

            /**
             * 放入桶中
             */
            bucket[locationElement][bucketElementCount[locationElement]]=arrays[i];
            //记录桶中的元素个数
            bucketElementCount[locationElement]++;
        }

        /**
         * 遍历每一个桶，将元素存放回原数组中
         */
        int index=0;
        for (int i = 0; i < bucketElementCount.length; i++) {
            if(bucketElementCount[i]!=0){
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arrays[index++]=bucket[i][j];
                }
            }
            bucketElementCount[i]=0;
        }

        /**
         * 判断十位
         */
        for (int i = 0; i < arrays.length; i++) {
            int locationElement=arrays[i]/10%10;

            /**
             * 放入桶中
             */
            bucket[locationElement][bucketElementCount[locationElement]]=arrays[i];
            //记录桶中的元素个数
            bucketElementCount[locationElement]++;
        }

        /**
         * 遍历每一个桶，将元素存放回原数组中
         */
        index=0;
        for (int i = 0; i < bucketElementCount.length; i++) {
            if(bucketElementCount[i]!=0){
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arrays[index++]=bucket[i][j];
                }
            }
            bucketElementCount[i]=0;
        }

        /**
         * 判断百位
         */
        for (int i = 0; i < arrays.length; i++) {
            int locationElement=arrays[i]/100%10;

            /**
             * 放入桶中
             */
            bucket[locationElement][bucketElementCount[locationElement]]=arrays[i];
            //记录桶中的元素个数
            bucketElementCount[locationElement]++;
        }

        /**
         * 遍历每一个桶，将元素存放回原数组中
         */
        index=0;
        for (int i = 0; i < bucketElementCount.length; i++) {
            if(bucketElementCount[i]!=0){
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arrays[index++]=bucket[i][j];
                }
            }
            bucketElementCount[i]=0;
        }

        System.out.println("排序后的序列："+Arrays.toString(arrays));
    }
}
