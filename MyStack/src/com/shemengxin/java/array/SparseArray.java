package com.shemengxin.java.array;

/**
 * ϡ������
 */
public class SparseArray {
    public static void main(String[] args) {
        /**
         * 1.ģ������������ݣ�ʹ�ö�ά����
         */
        int[][] array=new int[11][11];
        array[1][2]=1;
        array[2][4]=2;

        //��ӡ���̲鿴Ч��
        for (int[] row:array){
            for (int val:row){
                System.out.printf("%d\t",val);
            }
            System.out.println();
        }

        /**
         * ��Ҫ�����ϵĶ�ά��������Ч����ѹ��ϡ��������ȥ
         */
        //�����ά��������Ч����
        int sum=0;
        for (int i=0;i<11;i++){
            for (int j = 0; j <11 ; j++) {
                if (array[i][j]!=0){
                    sum++;
                }
            }
        }

        //����ϡ������
        int[][] sparseArray=new int[sum+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;

        //����Ч���ݴ����ϡ��������ȥ
        int count=0;
        for (int i = 0; i < 11; i++) {//�е�����
            for (int j = 0; j < 11; j++) {//�е�����
                //�ж��Ƿ�����Ч����
                if (array[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=array[i][j];
                }
            }
        }

        /**
         * ��ӡϡ������
         */
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d,%d,%d\t",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

        /**
         * ��ϡ������תԭʼ��ά���飨�����⣩
         */
        int[][] oldArray=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <=count; i++) {
            oldArray[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }

        System.out.println("\n-----------------------------------------------");

        /**
         * ԭʼ��ά��������
         */
        for(int[] row:oldArray){
            for (int val:row){
                System.out.printf("%d\t",val);
            }
            System.out.println();
        }
    }
}
