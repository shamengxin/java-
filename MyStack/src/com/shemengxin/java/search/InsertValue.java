package com.shemengxin.java.search;

import java.util.Arrays;

/**
 * ��ֵ����
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

    //��д��ֵ�����㷨
    /**
     * ���㷨��Ҫ�����������
     * @param arr ����
     * @param left ��ߵ�����
     * @param right �ұߵ�����
     * @param findVal ����ֵ
     * @return
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){

        //���������ж��Ǳ���Ҫ�ģ���ΪfinVal���ֵ������mid�����㣬���findVal���ֵ�ر��Ļ�����
        //����midҲ�ܴ󣬴Ӷ���������Խ�硣
        if(left>right || findVal<arr[0] || findVal>arr[arr.length-1]){

            return -1;

        }

        //���mid
        int mid = left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];
        if(findVal>midVal){//���ҵݹ�

            return insertValueSearch(arr,mid+1,right,findVal);

        } else if (findVal < midVal) {//����ݹ�

            return insertValueSearch(arr,left,mid-1,findVal);

        }else{

            return mid;

        }

    }

}
