package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序
 */
public class MergetSort {

    public static void main(String[] args) {

        // int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        // 创建一个有80000个随机值的数组
        int[] arr=new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*80000);//生成一个[0,80000)数
        }

        int[] temp = new int[arr.length];//归并排序需要一个额外的空间

        System.out.println("排序前");
        // System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("排序输出的时间是="+date1Str);

        mergeSort(arr,0,arr.length-1,temp);

        System.out.println("排序后");
        // System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序输出的时间是="+date2Str);


    }

    //分+合的方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){

        if(left<right){

            int mid=(left+right)/2;//中间的索引
            //向左递归进行分组
            mergeSort(arr,left,mid,temp);
            //向右递归进行分组
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);

        }

    }

    //合并的方法
    /**
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left; //初始化i，左边有序序列的初始索引
        int j = mid + 1; //初始化j，右边有序序列的初始数列
        int t = 0; //指向temp数组的当前索引

        //(一)
        //先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {

            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，拷贝到temp数组
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {

                temp[t] = arr[j];
                t += 1;
                j += 1;

            }

        }


        //(二）
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp

            temp[t] = arr[i];
            t += 1;
            i += 1;

        }

        while (j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp

            temp[t] = arr[j];
            t += 1;
            j += 1;

        }

        //(三）
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        //注意：当数组中所有元素都被拆分开始合并时，第一次的left=0，right=1，然后第二次的left=2，right=3
        //以此类推，当所有单个元素被合并完成之后，用以上数组举例，第三次的left=0，right=3
        //最后一次的right=0，right=7
        while (tempLeft <= right) {

            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;

        }

    }


}
