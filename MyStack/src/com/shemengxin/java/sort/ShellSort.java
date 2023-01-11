package com.shemengxin.java.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ϣ������
 */
public class ShellSort {

    public static void main(String[] args) {

        // int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
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

        shellSort2(arr);

        System.out.println("�����");
        // System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
        String date2Str=simpleDateFormat.format(date2);
        System.out.println("���������ʱ����="+date2Str);

    }

    //�Խ���ʽ��ϣ����������Ż�-->��λ��
    public static void shellSort2(int[] arr){

        //�涨����������С����
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //�ӵ�gap��Ԫ�أ�����������ڵ������ֱ�Ӳ�������
            for (int i = gap; i < arr.length; i++) {

                //����ʹ���˲������򣬵���2�η���֮������Ԫ�ؾͲ���ֻ������Ԫ�أ�֮ǰ������Ԫ������
                // ������ð������ķ���������Ƚϣ�������������ʹ���˲���������иĽ������Ч��
                int j=i;
                int temp=arr[i];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }

                    //���˳�whileѭ���󣬾͸�temp�ҵ��˲���λ��
                    arr[j]=temp;
                }

            }

        }

    }

    //ʹ�����Ƶ��ķ����Ƶ�
    public static void shellSort(int[] arr) {

        int temp = 0;
        int count=0;

        //�ܽ�
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i <arr.length ; i++) {

                for (int j = i - gap; j >= 0; j -= gap) {
                    //�����ǰԪ�ش��ڼ��ϲ���֮���Ԫ�أ�˵������
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

            // System.out.println("ϣ�������"+(++count)+"�֣�"+Arrays.toString(arr));

        }

        //ϣ������ĵ�1������
        //һ�㶼�����һ���������������һ�㶼������������һ�룬�����������������
        // һ����������Ԫ�ظ���Ϊż�������ڵ�һ�η���ʱ��ÿ��Ԫ��������
        // ��һ�־���Ԫ�ظ���Ϊ���������ڵ�һ�˷���ʱ����һ�����Ԫ��������
        /*for (int i = 5; i < arr.length; i++) {
            //�������������е�Ԫ�أ���5�飬ÿ����2��Ԫ�أ�������5
            //����������࣬���ÿ��Ԫ�ز�ֹ������
            //j-=5 ����������˳���ѭ����
            for (int j = i - 5; j >= 0; j -= 5) {
                //�����ǰԪ�ش��ڼ��ϲ���֮���Ԫ�أ�˵������
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        System.out.println("ϣ������1�ֺ�" + Arrays.toString(arr));

        //ϣ������ĵ�2������
        //֮�󲽳�Ϊǰ�沽����һ��
        //��Ϊ��2�������ǽ�10�����ݷֳ���2��
        for (int i = 2; i < arr.length; i++) {
            //�������������е�Ԫ�أ���5�飬ÿ����2��Ԫ�أ�������5
            //����������࣬���ÿ��Ԫ�ز�ֹ������
            //j-=5 ����������˳���ѭ����
            for (int j = i - 2; j >= 0; j -= 2) {
                //�����ǰԪ�ش��ڼ��ϲ���֮���Ԫ�أ�˵������
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }

        System.out.println("ϣ������2�ֺ�" + Arrays.toString(arr));

        //ϣ������ĵ�3������
        //��Ϊ��3�������ǽ�10�����ݷֳ���2��
        for (int i = 1; i < arr.length; i++) {
            //�������������е�Ԫ�أ���5�飬ÿ����2��Ԫ�أ�������5
            //����������࣬���ÿ��Ԫ�ز�ֹ������
            //j-=5 ����������˳���ѭ����
            for (int j = i - 1; j >= 0; j -= 1) {
                //�����ǰԪ�ش��ڼ��ϲ���֮���Ԫ�أ�˵������
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("ϣ������1�ֺ�" + Arrays.toString(arr));*/

    }


}
