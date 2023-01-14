package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

    public static void main(String[] args) {

        // int[] arr = {-9, 78, 0, 23, -567, 70};
        // ����һ����80000�����ֵ������
        int[] arr=new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*80000);//����һ��[0,80000)��
        }
        System.out.println("����ǰ");
        // System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str=simpleDateFormat.format(date1);
        System.out.println("���������ʱ����="+date1Str);

        quickSort(arr,0,arr.length-1);

        System.out.println("�����");
        // System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("���������ʱ����="+date2Str);
    }

    public static void quickSort(int[] arr, int left, int right) {

        int l = left;//���±�
        int r = right;//���±�
        //pivot ����ֵ
        int pivot = arr[(left + right) / 2];
        int temp = 0;//��ʱ����
        //whileѭ����Ŀ�����ñ�pivotС��ֵ�ŵ���ߣ�
        //��pivot���ֵ�ŵ��ұ�
        while (l < r) {
            //��pivot�����һֱ�ң��ҵ����ڵ���pivot��ֵ�����˳�
            while (arr[l] < pivot) {

                l += 1;

            }
            //��pivot���ұ�һֱ�ң��ҵ�С�ڵ���pivot��ֵ�����˳�
            while (arr[r] > pivot) {

                r -= 1;

            }
            //���l >= r˵��pivot ���������ߵ�ֵ���Ѿ�����
            // ���ȫ������С�ڵ���pivotֵ���ұ�ȫ�����Ǵ��ڵ���pivotֵ
            if (l >= r) {

                break;

            }
            // ����
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //���������󣬷������arr[l] == pivot
            if (arr[l] == pivot) {

                r -= 1;

            }
            //���������󣬷������arr[r] == pivot
            if (arr[r] == pivot) {

                l += 1;

            }

        }
        //���l==r,����l++,r--,����Ϊ����ջ���
            if(l==r){

                l+=1;
                r-=1;

            }

        //����ݹ�
        if(left <r){

            quickSort(arr,left,r);

        }

        if (right>l){

            quickSort(arr,l,right);

        }

    }

}
