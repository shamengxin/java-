package com.shemengxin.java.sort;

import java.util.Arrays;

/**
 * ��������
 */
public class BasicSort {
    public static void main(String[] args) {
        int[] arrays=new int[]{53,542,3,63,14,214,154,748,616};

        sort(arrays);
    }

    /**
     * 1.��ȡԭ���е����λ����
     * @param arrays
     */
    public static void sort(int[] arrays){

        /**
         * ��ȡ���λ��
         */
        int max=0;
        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i]>max){
                max=arrays[i];
            }
        }
        /**
         * ��ȡ�ַ������ȣ����԰�int����ת�����ַ�������
         */
        int maxLength=(max+"").length();

        /**
         * �����ά���飬��С10����ʾ10��Ͱ��ÿһ��Ͱ����һ������
         * [[],[],[],[],....]
         */
        int[][] bucket=new int[10][arrays.length];
        /**
         * ��������
         */
        int[] bucketElementCount=new int[10];

        /**
         * �жϸ�λ
         */
        for (int i = 0; i < arrays.length; i++) {
            int locationElement=arrays[i]/1%10;

            /**
             * ����Ͱ��
             */
            bucket[locationElement][bucketElementCount[locationElement]]=arrays[i];
            //��¼Ͱ�е�Ԫ�ظ���
            bucketElementCount[locationElement]++;
        }

        /**
         * ����ÿһ��Ͱ����Ԫ�ش�Ż�ԭ������
         */
        int index=0;
        for (int i = 0; i < bucketElementCount.length; i++) {
            if(bucketElementCount[i]!=0){
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arrays[index++]=bucket[i][j];
                }
            }
            bucketElementCount[i]=0;
        }

        /**
         * �ж�ʮλ
         */
        for (int i = 0; i < arrays.length; i++) {
            int locationElement=arrays[i]/10%10;

            /**
             * ����Ͱ��
             */
            bucket[locationElement][bucketElementCount[locationElement]]=arrays[i];
            //��¼Ͱ�е�Ԫ�ظ���
            bucketElementCount[locationElement]++;
        }

        /**
         * ����ÿһ��Ͱ����Ԫ�ش�Ż�ԭ������
         */
        index=0;
        for (int i = 0; i < bucketElementCount.length; i++) {
            if(bucketElementCount[i]!=0){
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arrays[index++]=bucket[i][j];
                }
            }
            bucketElementCount[i]=0;
        }

        /**
         * �жϰ�λ
         */
        for (int i = 0; i < arrays.length; i++) {
            int locationElement=arrays[i]/100%10;

            /**
             * ����Ͱ��
             */
            bucket[locationElement][bucketElementCount[locationElement]]=arrays[i];
            //��¼Ͱ�е�Ԫ�ظ���
            bucketElementCount[locationElement]++;
        }

        /**
         * ����ÿһ��Ͱ����Ԫ�ش�Ż�ԭ������
         */
        index=0;
        for (int i = 0; i < bucketElementCount.length; i++) {
            if(bucketElementCount[i]!=0){
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arrays[index++]=bucket[i][j];
                }
            }
            bucketElementCount[i]=0;
        }

        System.out.println("���������У�"+Arrays.toString(arrays));
    }
}
