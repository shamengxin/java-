package com.shemengxin.java.doublylinked;

/**
 * ˫���������
 */
public class LinkedTest {
    public static void main(String[] args) {
        DualLinkedList dualLinkedList=new DualLinkedList();

        BookNode bookNode1=new BookNode(1,"��¥��",55.00);
        BookNode bookNode2=new BookNode(2,"��������",55.00);
        BookNode bookNode3=new BookNode(3,"���μ�",55.00);
        BookNode bookNode4=new BookNode(4,"ˮ䰴�",55.00);

        dualLinkedList.addLast(bookNode1);
        dualLinkedList.addLast(bookNode2);
        dualLinkedList.addLast(bookNode3);
        dualLinkedList.addLast(bookNode4);

        //dualLinkedList.delNode(1);
        //dualLinkedList.updateNode(new BookNode(3,"�����",66.00));
        System.out.println();
    }
}
