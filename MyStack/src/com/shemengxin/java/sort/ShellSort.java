package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {

        // int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
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

        shellSort2(arr);

        System.out.println("排序后");
        // System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序输出的时间是="+date2Str);

    }

    //对交换式的希尔排序进行优化-->移位法
    public static void shellSort2(int[] arr){

        //规定步长，逐步缩小步长
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {

                //这里使用了插入排序，当第2次分组之后，组中元素就不在只有两个元素，之前的组内元素排序，
                // 类似于冒泡排序的方法，逐个比较，进行排序，这里使用了插入排序进行改进，提高效率
                int j=i;
                int temp=arr[i];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }

                    //当退出while循环后，就给temp找到了插入位置
                    arr[j]=temp;
                }

            }

        }

    }

    //使用逐步推到的方法推导
    public static void shellSort(int[] arr) {

        int temp = 0;
        int count=0;

        //总结
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i <arr.length ; i++) {

                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长之后的元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

            // System.out.println("希尔排序第"+(++count)+"轮："+Arrays.toString(arr));

        }

        //希尔排序的第1轮排序
        //一般都会给定一个步长，这个步长一般都会是这个数组的一半，这就造就了两种情况，
        // 一种是数组中元素个数为偶数个，在第一次分组时，每组元素有两个
        // 另一种就是元素个数为奇数个，在第一此分组时，有一个组的元素有三个
        /*for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组有2个元素），步长5
            //这个并不多余，如果每组元素不止两个呢
            //j-=5 这个是用来退出此循环的
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长之后的元素，说明交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        System.out.println("希尔排序1轮后：" + Arrays.toString(arr));

        //希尔排序的第2轮排序
        //之后步长为前面步长的一半
        //因为第2轮排序，是将10个数据分成了2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组有2个元素），步长5
            //这个并不多余，如果每组元素不止两个呢
            //j-=5 这个是用来退出此循环的
            for (int j = i - 2; j >= 0; j -= 2) {
                //如果当前元素大于加上步长之后的元素，说明交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }

        System.out.println("希尔排序2轮后：" + Arrays.toString(arr));

        //希尔排序的第3轮排序
        //因为第3轮排序，是将10个数据分成了2组
        for (int i = 1; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组有2个元素），步长5
            //这个并不多余，如果每组元素不止两个呢
            //j-=5 这个是用来退出此循环的
            for (int j = i - 1; j >= 0; j -= 1) {
                //如果当前元素大于加上步长之后的元素，说明交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("希尔排序1轮后：" + Arrays.toString(arr));*/

    }


}
