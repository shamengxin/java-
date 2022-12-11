package com.shemengxin.java.maze;

/**
 * �Թ�����
 */
public class MazeApp {
    public static void main(String[] args) {
        //�����Թ�
        int [][] map =new int[8][7];

        /**
         * ���õ�һ�к����һ��Ϊǽ������Ϊ1
         */
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }

        /**
         * ���õ�һ���͵�����Ϊǽ
         */
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }

        /**
         * �����ϰ�ǽ
         */
        map[3][1]=1;
        map[3][2]=1;

        System.out.println("�µ��Թ�");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        isRun(map ,1,1);

        System.out.println("�߹���·��");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 1.С�����һ��λ�ÿ�ʼ��������ʼλ�� 1��1
     * 2.map�ǵ�ͼ����
     * 3.����С��ﵽ�� 6��5
     * 4.Ԫ��Ϊ0ʱ����ʾ�õ�û���߹���Ԫ��Ϊ1��ʾ��ǽ��Ԫ��Ϊ2ʱ����ʾͨ�������ߣ���Ԫ��Ϊ3ʱ����ʾ�õ��Ѿ��߹��ˣ�
     * �����߲�ͨ��
     */
    public static boolean isRun(int[][] map,int i,int j){
        //�յ�
        if(map[6][5]==2){
            return  true;
        }else{
            if(map[i][j]==0){//û���߹��õ�
                map[i][j]=2;

                //�ϡ��¡�����
                if(isRun(map,i+1,j)){
                    return true;
                } else if (isRun(map, i, j+1)) {
                    return true;
                } else if (isRun(map, i-1, j)) {
                    return true;
                } else if (isRun(map, i, j-1)) {
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
