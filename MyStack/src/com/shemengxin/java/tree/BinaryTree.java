package com.shemengxin.java.tree;

//定义BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    //为了实现线索化，需要前驱结点，所以定义一个指针
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //遍历线索化二叉树的方法
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

    //编写对二叉树进行中序线索化的方法
    public void threadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        //线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前结点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;
        //线索化右子树
        threadedNodes(node.getRight());

    }

    //删除结点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }

        } else {
            System.out.println("空树");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

}
