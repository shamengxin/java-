package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

    public static void main(String[] args) {

        // int[] arr = {101, 34, 119, 1};

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

        insertSort(arr);

        System.out.println("排序后");
        // System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序输出的时间是="+date2Str);

    }

    //插入排序
    public static void insertSort(int[] arr) {

        int insertVal=0;
        int insertIndex=0;
        //使用for循环进行代码简化
        for (int i = 1; i < arr.length; i++) {

            //定义待插入的数
            insertVal = arr[i];
            //即arr[1]的前面这个数的下标
            insertIndex = i - 1;

            //给insertVal找到插入的位置
            //1.insertIndex>=0保证在给insertVal 找插入位置时，不越界
            //2.insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            //3.就需要将arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;

            }
            //当退出while循环时，说明插入的位置找到，insertIndex+1
            if(i!=(insertIndex+1)) {
                arr[insertIndex + 1] = insertVal;
            }
            // System.out.println("第"+i+"轮插入：");
            // System.out.println(Arrays.toString(arr));

        }

        //使用逐步推导的方式来写
        //第1轮{101,34,119,1}==》{34，101,119,1}

        /*//定义待插入的数
        int insertVal = arr[1];
        //即arr[1]的前面这个数的下标
        int insertIndex = 1 - 1;

        //给insertVal找到插入的位置
        //1.insertIndex>=0保证在给insertVal 找插入位置时，不越界
        //2.insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        //3.就需要将arr[insertIndex] 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;

        }
        //当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex + 1] = insertVal;

        System.out.println("第1轮插入：");
        System.out.println(Arrays.toString(arr));

        //第2轮：
        insertVal = arr[2];
        insertIndex = 2 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;

        }
        arr[insertIndex + 1] = insertVal;

        System.out.println("第2轮插入：");
        System.out.println(Arrays.toString(arr));

        //第3轮：
        insertVal = arr[3];
        insertIndex = 3 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;

        }
        arr[insertIndex + 1] = insertVal;

        System.out.println("第3轮插入：");
        System.out.println(Arrays.toString(arr));*/
    }

}
