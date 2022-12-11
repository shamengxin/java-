package com.shemengxin.java.queue;

import java.io.StringReader;

/**
 * ����ʵ�ֶ��У�����
 */
public class ArrayQueue {
    private int[] array;

    private int maxSize;

    private int frontPoint;

    private int rearPoint;

    /**
     * ��ʼ��
     * @param maxSize
     */
    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        array=new int[maxSize];

        frontPoint=-1;
        rearPoint=-1;
    }

    /**
     * �жϵ�ǰ�����Ƿ�����
     */
    public boolean isFull(){
        return rearPoint==maxSize-1;
    }

    /**
     * �ж϶����Ƿ�Ϊ��
     */
    public boolean isEmpty(){
        return frontPoint==rearPoint;
    }

    /**
     * ���Ԫ�ؽ������
     */
    public void add(int n){
        //�ж϶����Ƿ�����
        if (isFull()){
            System.out.println("��������");
            return;
        }
        rearPoint++;
        array[rearPoint]=n;

    }

    /**
     * ��ȡ����Ԫ�ز�ɾ��Ԫ�أ�������
     */
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("�ն���");
        }
        frontPoint++;
        return array[frontPoint];
    }

    /**
     * �鿴�����е�Ԫ��
     */
    public void findQueue(){
        if (isEmpty()){
            throw new RuntimeException("�ն���");
        }
        for (int i = 0; i <array.length ; i++) {
            System.out.printf("array[%d]=%d\n",i,array[i]);
        }
    }

    /**
     * �鿴��ͷԪ�أ������ǳ�����
     */
    public int frontQueue(){
        if(isEmpty()){
            throw new RuntimeException("�ն���");
        }
        return array[frontPoint+1];
    }
}
