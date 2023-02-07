package com.shemengxin.java.tree;

public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;//默认为空
    private HeroNode right;//默认为空

    //如果leftType==0表示指向的是左子树，如果1表示指向前驱结点
    private int leftType;
    //如果rightType==0表示指向的是右子树，如果1表示指向后继结点
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

    //递归删除结点
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

    //编写前序遍历的方法
    public void preOrder() {
        //先输出父节点
        System.out.println(this);
        //向左遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //向右遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //向左遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //先输出父节点
        System.out.println(this);
        //向右遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后续遍历
    public void postOrder() {
        //向左遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //向右遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //先输出父节点
        System.out.println(this);
    }

    //前序遍历查找

    /**
     * @param no 查找no
     * @return 如果找到就返回该Node，如果没有找到返回null
     */
    public HeroNode preOrderSearch(int no) {
        //比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        //1. 判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2. 如果左递归前序查找，找到结点，则返回
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) { //说明我们左子树找到
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) { //说明我们左子树找到
            return heroNode;
        }

        //比较当前结点是不是
        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        HeroNode heroNode = null;

        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) { //说明我们左子树找到
            return heroNode;
        }

        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }

        if (heroNode != null) { //说明我们左子树找到
            return heroNode;
        }

        //比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        return heroNode;

    }
}
