package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {

    public static void main(String[] args) {

        // int[] arr = {53, 3, 542, 748, 14, 214};

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

        radixSort(arr);

        System.out.println("�����");
        // System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("���������ʱ����="+date2Str);
    }

    //�������򷽷�
    public static void radixSort(int[] arr) {

        //����ǰ����Ƶ����̣����ǿ��Եõ����յĻ����������
        //1.�õ���������������λ��
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //�õ���������Ǽ�λ��
        int maxLength = (max + "").length();

        //����һ����ά���飬��ʾ10��Ͱ��ÿ��Ͱ����һ��һά����
        //˵����
        //1.��ά�������10��һά����
        //2.Ϊ�˷�ֹ�ڷ�������ʱ�������������ÿ��һά���飨Ͱ������С��Ϊarr.length
        //3.�����ԣ�����������ʹ�ÿռ任ʱ��ľ����㷨
        int[][] bucket = new int[10][arr.length];

        //Ϊ�˼�¼ÿ��Ͱ�У�ʵ�ʴ���˶��ٸ����ݣ����Ƕ���һ��һά��������¼����Ͱ��ÿ�η�������ݸ���
        //�����������
        //���磺bucketElementCounts[0],��¼�ľ���bucket[0]Ͱ�����ݵĴ�Ÿ���
        int[] bucketElementCounts = new int[10];

        //��������ʹ��ѭ�������봦��
        for (int k = 0, n = 1; k < maxLength; k++, n *= 10) {

            //�����ÿ��Ԫ�ص�λ����������
            for (int i = 0; i < arr.length; i++) {

                //ȡ��ÿ��Ԫ�صĸ�λ
                int digitOfElement = arr[i] / n % 10;
                //���뵽��Ӧ��Ͱ��
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;

            }

            //�������Ͱ��˳��һά������±�����ȡ�����ݣ�����ԭ�������飩
            int index = 0;
            //����ÿһͰ������Ͱ�����ݣ����뵽ԭ��������
            for (int i = 0; i < bucketElementCounts.length; i++) {
                //���Ͱ�������ݣ����ǲŷŵ�ԭ������
                if (bucketElementCounts[i] != 0) {
                    //ѭ����Ͱ����i��Ͱ������i��һά���飩������
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        //ȡ��Ԫ�ط��뵽arr
                        arr[index++] = bucket[i][j];
                    }

                }
                //ע�⣺��Ҫ���bucketElementCounts�е����ݣ������´α���
                bucketElementCounts[i] = 0;

            }

            // System.out.println("��" + (k + 1) + "�֣��Ը�λ��������arr=" + Arrays.toString(arr));

        }


        //��1�֣����ÿ��Ԫ�صĸ�λ����������
        /*for (int i = 0; i < arr.length; i++) {

            //ȡ��ÿ��Ԫ�صĸ�λ
            int digitOfElement = arr[i]/1%10;
            //���뵽��Ӧ��Ͱ��
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
            bucketElementCounts[digitOfElement]++;

        }

        //�������Ͱ��˳��һά������±�����ȡ�����ݣ�����ԭ�������飩
        int index= 0;
        //����ÿһͰ������Ͱ�����ݣ����뵽ԭ��������
        for (int i = 0; i < bucketElementCounts.length; i++) {
            //���Ͱ�������ݣ����ǲŷŵ�ԭ������
            if(bucketElementCounts[i]!=0){
                //ѭ����Ͱ����i��Ͱ������i��һά���飩������
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //ȡ��Ԫ�ط��뵽arr
                    arr[index++]= bucket[i][j];
                }

            }
            //ע�⣺��Ҫ���bucketElementCounts�е����ݣ������´α���
            bucketElementCounts[i]=0;

        }

        System.out.println("��1�֣��Ը�λ��������arr="+ Arrays.toString(arr));

        //===============================================================================

        //��2�֣����ÿ��Ԫ�ص�ʮλ����������
        for (int i = 0; i < arr.length; i++) {

            //ȡ��ÿ��Ԫ�صĸ�λ
            int digitOfElement = arr[i]/10%10;
            //���뵽��Ӧ��Ͱ��
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
            bucketElementCounts[digitOfElement]++;

        }

        //�������Ͱ��˳��һά������±�����ȡ�����ݣ�����ԭ�������飩
        index= 0;
        //����ÿһͰ������Ͱ�����ݣ����뵽ԭ��������
        for (int i = 0; i < bucketElementCounts.length; i++) {
            //���Ͱ�������ݣ����ǲŷŵ�ԭ������
            if(bucketElementCounts[i]!=0){
                //ѭ����Ͱ����i��Ͱ������i��һά���飩������
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //ȡ��Ԫ�ط��뵽arr
                    arr[index++]= bucket[i][j];
                }

            }

            bucketElementCounts[i]=0;

        }

        System.out.println("��2�֣���ʮλ��������arr="+ Arrays.toString(arr));

        //===============================================================================

        //��3�֣����ÿ��Ԫ�صİ�λ����������
        for (int i = 0; i < arr.length; i++) {

            //ȡ��ÿ��Ԫ�صĸ�λ
            int digitOfElement = arr[i]/100%10;
            //���뵽��Ӧ��Ͱ��
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
            bucketElementCounts[digitOfElement]++;

        }

        //�������Ͱ��˳��һά������±�����ȡ�����ݣ�����ԭ�������飩
        index= 0;
        //����ÿһͰ������Ͱ�����ݣ����뵽ԭ��������
        for (int i = 0; i < bucketElementCounts.length; i++) {
            //���Ͱ�������ݣ����ǲŷŵ�ԭ������
            if(bucketElementCounts[i]!=0){
                //ѭ����Ͱ����i��Ͱ������i��һά���飩������
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    //ȡ��Ԫ�ط��뵽arr
                    arr[index++]= bucket[i][j];
                }

            }

            bucketElementCounts[i]=0;

        }

        System.out.println("��3�֣��԰�λ��������arr="+ Arrays.toString(arr));*/
    }

}
