package com.shemengxin.java.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //����Ҫ����һ�Ŷ�����
        BinaryTree binaryTree = new BinaryTree();
        //������Ҫ�Ľ��
        HeroNode root = new HeroNode(1, "�ν�");
        HeroNode node2 = new HeroNode(2, "����");
        HeroNode node3 = new HeroNode(3, "¬����");
        HeroNode node4 = new HeroNode(4, "�ֳ�");
        HeroNode node5 = new HeroNode(5, "��ʤ");

        //�ֶ�����������
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        /*//����
        System.out.println("ǰ�����");
        binaryTree.preOrder();
        System.out.println("�������");
        binaryTree.infixOrder();
        System.out.println("�������");
        binaryTree.postOrder();

        //ǰ���������
        System.out.println("ǰ���������~~");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.println("�ҵ��ˣ���ϢΪno=" + resNode.getNo() + "��name=" + resNode.getName());
        } else {
            System.out.println("û���ҵ�no=5��Ӣ��");
        }*/

        //����ɾ�����
        System.out.println("ɾ��ǰ��ǰ�����");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("ɾ����ǰ�����");
        binaryTree.preOrder();
    }
}

