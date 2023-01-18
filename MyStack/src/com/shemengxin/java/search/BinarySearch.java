package com.shemengxin.java.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���ֲ���
 * <p>
 * ע�⣺ʹ�ö��ֲ��ҵ�ǰ���Ǹ�����������ġ�
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        /*int resIndex = binarySearch(arr, 0, arr.length, 89);
        System.out.println("resIndex=" + resIndex);*/

        ArrayList<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(resIndexList);
    }

    //���ֲ���

    /**
     * �˶��ֲ���ֻ���ҳ������е�һ��ƥ���Ԫ���±�
     *
     * @param arr     ����
     * @param left    ��ߵ�����
     * @param right   �ұߵ�����
     * @param findVal Ҫ���ҵ�ֵ
     * @return ����ҵ��ͷ����±꣬���û���ҵ����ͷ���-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        if (left > right) {

            return -1;

        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {//���ҵݹ�

            return binarySearch(arr, mid + 1, right, findVal);

        } else if (findVal < midVal) {//����ݹ�

            return binarySearch(arr, left, mid - 1, findVal);

        } else {

            return mid;

        }

    }

    /**
     * �˷�����ѯ������������ƥ��Ԫ�ص��±�
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        if (left > right) {

            return new ArrayList<Integer>();

        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {//���ҵݹ�

            return binarySearch2(arr, mid + 1, right, findVal);

        } else if (findVal < midVal) {//����ݹ�

            return binarySearch2(arr, left, mid - 1, findVal);

        } else {

            ArrayList<Integer> resList = new ArrayList<Integer>();
            //����ɨ��
            int temp = mid - 1;
            while (true) {

                if (temp < 0 || arr[temp] != findVal) {

                    break;

                }

                //���ߣ��ͽ�temp���뵽resIndexList
                resList.add(temp);
                temp -= 1;

            }
            resList.add(mid);

            //����ɨ��
            temp = mid + 1;
            while (true) {

                if (temp > arr.length - 1 || arr[temp] != findVal) {

                    break;

                }

                //���ߣ��ͽ�temp���뵽resIndexList
                resList.add(temp);
                temp += 1;

            }
            return resList;

        }

    }

}


