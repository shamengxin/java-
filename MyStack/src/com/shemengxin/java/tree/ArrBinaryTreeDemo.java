package com.shemengxin.java.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

//编写一个ArrayBinaryTree，实现顺序存储二叉树遍历
class ArrBinaryTree{
    private int[] arr;//存储数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组为空，不能遍历");
        }
        System.out.println(arr[index]);
        if((index*2+1)< arr.length){
            preOrder(2*index+1);
        }
        if((index*2+2)< arr.length){
            preOrder(index*2+2);
        }
    }

    /*中序和后序遍历交换以下位置即可*/
}
