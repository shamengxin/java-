package com.shemengxin.java.circularlinkedlist;

public class CircleSingleLinkedList {

    private Boy first=new Boy(-1);

    /**
     * ������������
     */
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("��������");
            return;
        }

        Boy temp=null;
        for(int i=1;i<=nums;i++){
            Boy boy=new Boy(i);
            /**
             * �ж��Ƿ�Ϊ��һ��С��
             */
            if(i==1){
                first=boy;
                first.setNext(first);
                temp=first;
            }else{
                temp.setNext(boy);
                boy.setNext(first);
                temp=boy;
            }
        }
    }
}
