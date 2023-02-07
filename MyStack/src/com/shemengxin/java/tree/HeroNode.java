package com.shemengxin.java.tree;

public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;//Ĭ��Ϊ��
    private HeroNode right;//Ĭ��Ϊ��

    //���leftType==0��ʾָ����������������1��ʾָ��ǰ�����
    private int leftType;
    //���rightType==0��ʾָ����������������1��ʾָ���̽��
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

    //�ݹ�ɾ�����
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }

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

    //ǰ���������

    /**
     * @param no ����no
     * @return ����ҵ��ͷ��ظ�Node�����û���ҵ�����null
     */
    public HeroNode preOrderSearch(int no) {
        //�Ƚϵ�ǰ����ǲ���
        if (this.no == no) {
            return this;
        }
        //1. �жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
        //2. �����ݹ�ǰ����ң��ҵ���㣬�򷵻�
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) { //˵�������������ҵ�
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    //�����������
    public HeroNode infixOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) { //˵�������������ҵ�
            return heroNode;
        }

        //�Ƚϵ�ǰ����ǲ���
        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    //�����������
    public HeroNode postOrderSearch(int no) {
        HeroNode heroNode = null;

        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) { //˵�������������ҵ�
            return heroNode;
        }

        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }

        if (heroNode != null) { //˵�������������ҵ�
            return heroNode;
        }

        //�Ƚϵ�ǰ����ǲ���
        if (this.no == no) {
            return this;
        }
        return heroNode;

    }
}
