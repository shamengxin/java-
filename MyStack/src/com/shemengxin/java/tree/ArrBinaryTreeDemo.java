package com.shemengxin.java.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

//��дһ��ArrayBinaryTree��ʵ��˳��洢����������
class ArrBinaryTree{
    private int[] arr;//�洢���ݽ�������

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }

    //��дһ�����������˳��洢��������ǰ�����
    public void preOrder(int index){
        if(arr==null||arr.length==0){
            System.out.println("����Ϊ�գ����ܱ���");
        }
        System.out.println(arr[index]);
        if((index*2+1)< arr.length){
            preOrder(2*index+1);
        }
        if((index*2+2)< arr.length){
            preOrder(index*2+2);
        }
    }

    /*����ͺ��������������λ�ü���*/
}
