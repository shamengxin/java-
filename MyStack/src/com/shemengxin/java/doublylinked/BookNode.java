package com.shemengxin.java.doublylinked;

public class BookNode {
    public int id;
    public String name;
    public double price;

    //ǰ��
    public BookNode pre;
    //���
    public BookNode next;

    public BookNode(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
