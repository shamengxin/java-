package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {

    public static void main(String[] args) {

        // int[] arr = {53, 3, 542, 748, 14, 214};

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

        radixSort(arr);

        System.out.println("排序后");
        // System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("排序输出的时间是="+date2Str);
    }

    //基数排序方法
    public static void radixSort(int[] arr) {

        //根据前面的推导过程，我们可以得到最终的基数排序代码
        //1.得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到的最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //说明：
        //1.二维数组包含10个一维数组
        //2.为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定为arr.length
        //3.很明显，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这样理解
        //比如：bucketElementCounts[0],记录的就是bucket[0]桶中数据的存放个数
        int[] bucketElementCounts = new int[10];

        //这里我们使用循环将代码处理
        for (int k = 0, n = 1; k < maxLength; k++, n *= 10) {

            //（针对每个元素的位进行排序处理）
            for (int i = 0; i < arr.length; i++) {

                //取出每个元素的个位
                int digitOfElement = arr[i] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;

            }

            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
            int index = 0;
            //遍历每一桶，并将桶中数据，放入到原来数组中
            for (int i = 0; i < bucketElementCounts.length; i++) {
                //如果桶中有数据，我们才放到原数组中
                if (bucketElementCounts[i] != 0) {
                    //循环该桶即第i个桶（即第i个一维数组），放入
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[i][j];
                    }

                }
                //注意：需要清空bucketElementCounts中的数据，便于下次遍历
                bucketElementCounts[i] = 0;

            }

            // System.out.println("第" + (k + 1) + "轮，对个位的排序处理arr=" + Arrays.toString(arr));

        }


        //第1轮（针对每个元素的个位进行排序处理）
        /*for (int i = 0; i < arr.length; i++) {

            //取出每个元素的个位
            int digitOfElement = arr[i]/1%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
            bucketElementCounts[digitOfElement]++;

        }

        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
        int index= 0;
        //遍历每一桶，并将桶中数据，放入到原来数组中
        for (int i = 0; i < bucketElementCounts.length; i++) {
            //如果桶中有数据，我们才放到原数组中
            if(bucketElementCounts[i]!=0){
                //循环该桶即第i个桶（即第i个一维数组），放入
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //取出元素放入到arr
                    arr[index++]= bucket[i][j];
                }

            }
            //注意：需要清空bucketElementCounts中的数据，便于下次遍历
            bucketElementCounts[i]=0;

        }

        System.out.println("第1轮，对个位的排序处理arr="+ Arrays.toString(arr));

        //===============================================================================

        //第2轮（针对每个元素的十位进行排序处理）
        for (int i = 0; i < arr.length; i++) {

            //取出每个元素的个位
            int digitOfElement = arr[i]/10%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
            bucketElementCounts[digitOfElement]++;

        }

        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
        index= 0;
        //遍历每一桶，并将桶中数据，放入到原来数组中
        for (int i = 0; i < bucketElementCounts.length; i++) {
            //如果桶中有数据，我们才放到原数组中
            if(bucketElementCounts[i]!=0){
                //循环该桶即第i个桶（即第i个一维数组），放入
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //取出元素放入到arr
                    arr[index++]= bucket[i][j];
                }

            }

            bucketElementCounts[i]=0;

        }

        System.out.println("第2轮，对十位的排序处理arr="+ Arrays.toString(arr));

        //===============================================================================

        //第3轮（针对每个元素的百位进行排序处理）
        for (int i = 0; i < arr.length; i++) {

            //取出每个元素的个位
            int digitOfElement = arr[i]/100%10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
            bucketElementCounts[digitOfElement]++;

        }

        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
        index= 0;
        //遍历每一桶，并将桶中数据，放入到原来数组中
        for (int i = 0; i < bucketElementCounts.length; i++) {
            //如果桶中有数据，我们才放到原数组中
            if(bucketElementCounts[i]!=0){
                //循环该桶即第i个桶（即第i个一维数组），放入
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //取出元素放入到arr
                    arr[index++]= bucket[i][j];
                }

            }

            bucketElementCounts[i]=0;

        }

        System.out.println("第3轮，对百位的排序处理arr="+ Arrays.toString(arr));*/
    }

}
