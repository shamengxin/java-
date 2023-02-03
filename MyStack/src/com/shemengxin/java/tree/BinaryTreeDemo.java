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

        //����
        System.out.println("ǰ�����");
        binaryTree.preOrder();
        System.out.println("�������");
        binaryTree.infixOrder();
        System.out.println("�������");
        binaryTree.postOrder();
    }
}

//����BinaryTree ������
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //ǰ�����
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

}

//�ȴ���HeroNode���
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;//Ĭ��Ϊ��
    private HeroNode right;//Ĭ��Ϊ��

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //��дǰ������ķ���
    public void preOrder() {
        //��������ڵ�
        System.out.println(this);
        //�������
        if (this.left != null) {
            this.left.preOrder();
        }
        //���ұ���
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //�������
    public void infixOrder() {
        //�������
        if (this.left != null) {
            this.left.infixOrder();
        }
        //��������ڵ�
        System.out.println(this);
        //���ұ���
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //��������
    public void postOrder() {
        //�������
        if (this.left != null) {
            this.left.postOrder();
        }
        //���ұ���
        if (this.right != null) {
            this.right.postOrder();
        }
        //��������ڵ�
        System.out.println(this);
    }
}
