package com.shemengxin.java.linked;

public class LinkedTest {
    public static void main(String[] args) {
        DLLinkedList linkedList=new DLLinkedList();

        GoodsNode goodsNode1=new GoodsNode(1,"��Ь",288.00);
        GoodsNode goodsNode2=new GoodsNode(2,"ñ��",188.00);
        GoodsNode goodsNode3=new GoodsNode(3,"����",388.00);
        GoodsNode goodsNode4=new GoodsNode(4,"����",288.00);

       /* linkedList.add(goodsNode1);
        linkedList.add(goodsNode2);
        linkedList.add(goodsNode3);
        linkedList.add(goodsNode4);*/

        linkedList.addOrder(goodsNode3);
        linkedList.addOrder(goodsNode1);
        linkedList.addOrder(goodsNode4);
        linkedList.addOrder(goodsNode2);

        //linkedList.updateNode(new GoodsNode(2,"����",188));

//        linkedList.delNode(3);
        System.out.println(linkedList.getLength());
        linkedList.list();
    }



}
