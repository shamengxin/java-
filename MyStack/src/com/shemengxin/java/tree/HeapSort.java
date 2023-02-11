package com.shemengxin.java.tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ������
 * ���򣺴󶥶�
 * ����С����
 * ˼·���£����Ƚ�����������鿴����һ��˳���������ͨ��arr.length/2-1�ĵ���һ����Ҷ�ӽ��A����������ص��ǣ����¿϶�
 * ֻ��Ҷ�ӣ�������һ��Ҳ�������������������Ҷ�ӽ��A����Ҷ�ӵ���һ��С�����������������бȽϣ��ҳ����Ľ�㣬��������A
 * �������п������Ľ�����A�������в�������Ȼ�������һ�ε�������i--�󣬼������ϱȽϲ��������������AΪ0ʱ��������
 * �����������ڽ��A����Ȼ�󽫽��A����������ĩβ�������н���������������������ĩβ��Ȼ���ٴ����½��е������������鳤��
 * arr.length��Ҫ-1.(������һ�εĵ���֮�����Ѿ�������Ϊ�������ε���������е����Ĵ�СҲ�����ε�����
 *
 *
 * ʹ��adjustHeap��ʾ�����仯����
 * adjustHeap(arr,1,5)=>(arr,0,5)=>(arr,0,4)=>(arr,0,3)=>(arr,0,2)
 * �������ⲽʱ���������
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //��дһ��������ķ���
    public static void heapSort(int arr[]) {
        System.out.println("������");
        int temp = 0;

        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //arr.lengthָ��������Ԫ�ظ���
        for (int j = arr.length-1; j >0; j--) {
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }

    }

    //��һ�����飨����������������һ���󶥶�

    /**
     * ���ܣ���ɽ���i��Ӧ�ķ�Ҷ�ӽ��������ɴ󶥶�
     *
     * @param arr    ������������
     * @param i      ��ʾ��Ҷ�ӽ���������е�����
     * @param length ��ʾ�Զ��ٸ�Ԫ�ؽ��е�����length �����𽥼���
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //��ʼ����
        //1.k = i * 2 + 1 k��i�������ӽ��
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//˵�����ӽڵ��ֵС�����ӽڵ��ֵ
                k++;//��kָ�����ӽڵ�
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;//iָ��k������ѭ���Ƚ�
            } else {
                break;
            }
        }
        arr[i]=temp;
    }

}

