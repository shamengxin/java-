package com.shemengxin.java.tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 堆排序
 * 升序：大顶堆
 * 降序：小顶堆
 * 思路如下：首先将待排序的数组看成是一个顺序二叉树，通过arr.length/2-1的到第一个非叶子结点A，这个结点的特点是，其下肯定
 * 只有叶子，可能是一个也可能是两个，把这个非叶子结点A和其叶子当做一颗小树，将这三个结点进行比较，找出最大的结点，将其与结点A
 * 互换（有可能最大的结点就是A，不进行操作），然后进入下一次调整（将i--后，继续如上比较操作，），当结点A为0时，整个数
 * 组最大的数就在结点A处，然后将结点A的数与数组末尾的数进行交换，将最大的数放至数组末尾，然后再次重新进行调整，但是数组长度
 * arr.length需要-1.(经过第一次的调整之后，树已经被调整为层数依次递增，其层中的数的大小也是依次递增）
 *
 *
 * 使用adjustHeap演示参数变化如下
 * adjustHeap(arr,1,5)=>(arr,0,5)=>(arr,0,4)=>(arr,0,3)=>(arr,0,2)
 * 参数到这步时，排序完成
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        System.out.println("堆排序");
        int temp = 0;

        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //arr.length指的是数组元素个数
        for (int j = arr.length-1; j >0; j--) {
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }

    }

    //将一个数组（二叉树），调整成一个大顶堆

    /**
     * 功能：完成将以i对应的非叶子结点的数调成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中的索引
     * @param length 表示对多少个元素进行调整，length 是在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //开始调整
        //1.k = i * 2 + 1 k是i结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//说明左子节点的值小于右子节点的值
                k++;//将k指向右子节点
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;//i指向k，继续循环比较
            } else {
                break;
            }
        }
        arr[i]=temp;
    }

}

