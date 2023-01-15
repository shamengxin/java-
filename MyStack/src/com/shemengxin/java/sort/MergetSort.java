package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * �鲢����
 */
public class MergetSort {

    public static void main(String[] args) {

        // int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};

        // ����һ����80000�����ֵ������
        int[] arr=new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*80000);//����һ��[0,80000)��
        }

        int[] temp = new int[arr.length];//�鲢������Ҫһ������Ŀռ�

        System.out.println("����ǰ");
        // System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("���������ʱ����="+date1Str);

        mergeSort(arr,0,arr.length-1,temp);

        System.out.println("�����");
        // System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("���������ʱ����="+date2Str);


    }

    //��+�ϵķ���
    public static void mergeSort(int[] arr,int left,int right,int[] temp){

        if(left<right){

            int mid=(left+right)/2;//�м������
            //����ݹ���з���
            mergeSort(arr,left,mid,temp);
            //���ҵݹ���з���
            mergeSort(arr,mid+1,right,temp);
            //�ϲ�
            merge(arr,left,mid,right,temp);

        }

    }

    //�ϲ��ķ���
    /**
     * @param arr   �����ԭʼ����
     * @param left  ����������еĳ�ʼ����
     * @param mid   �м�����
     * @param right �ұ�����
     * @param temp  ����ת������
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left; //��ʼ��i������������еĳ�ʼ����
        int j = mid + 1; //��ʼ��j���ұ��������еĳ�ʼ����
        int t = 0; //ָ��temp����ĵ�ǰ����

        //(һ)
        //�Ȱ��������ߣ����򣩵����ݰ��չ�����䵽temp����
        //ֱ���������ߵ��������У���һ�ߴ������Ϊֹ
        while (i <= mid && j <= right) {

            //�����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұ��������еĵ�ǰԪ��
            //������ߵĵ�ǰԪ�أ�������temp����
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


        //(����
        //����ʣ�����ݵ�һ�ߵ���������ȫ����䵽temp
        while (i <= mid) { //��ߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp

            temp[t] = arr[i];
            t += 1;
            i += 1;

        }

        while (j <= right) { //�ұߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp

            temp[t] = arr[j];
            t += 1;
            j += 1;

        }

        //(����
        //��temp�����Ԫ�ؿ�����arr
        //ע�⣬������ÿ�ζ���������
        t = 0;
        int tempLeft = left;
        //ע�⣺������������Ԫ�ض�����ֿ�ʼ�ϲ�ʱ����һ�ε�left=0��right=1��Ȼ��ڶ��ε�left=2��right=3
        //�Դ����ƣ������е���Ԫ�ر��ϲ����֮����������������������ε�left=0��right=3
        //���һ�ε�right=0��right=7
        while (tempLeft <= right) {

            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;

        }

    }


}
