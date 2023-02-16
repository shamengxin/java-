package com.shemengxin.java.huffman.huffmancode;

/**
 * 赫夫曼编码的结点
 */
public class Node implements Comparable<Node>{
    private Byte date; //存放数据本身 如'a'=>97
    private int weight; //权值，表示字符出现的次数
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(Byte date, int weight) {
        this.date = date;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "date=" + date +
                ", weight=" + weight +
                '}';
    }

    public Byte getDate() {
        return date;
    }

    public void setDate(Byte date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}
