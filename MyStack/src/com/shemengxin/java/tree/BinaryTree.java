package com.shemengxin.java.tree;

//����BinaryTree ������
class BinaryTree {
    private HeroNode root;

    //Ϊ��ʵ������������Ҫǰ����㣬���Զ���һ��ָ��
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //�����������������ķ���
    public void threadedList(){
        HeroNode node = root;
        while(node!=null){
            while ((node.getLeftType()==0)){
                node= node.getLeft();
            }

            System.out.println(node);

            while(node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }

            node=node.getRight();
        }
    }

    //��д�Զ��������������������ķ���
    public void threadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        //������������
        threadedNodes(node.getLeft());
        //��������ǰ���
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;
        //������������
        threadedNodes(node.getRight());

    }

    //ɾ�����
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }

        } else {
            System.out.println("����");
        }
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

    //ǰ���������
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //�����������
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //�����������
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

}
