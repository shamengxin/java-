package com.shemengxin.java.hashtab;

/**
 * 创建HashTab管理多条链表
 */
public class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;//共有多少条链表

    //构造器
    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //留一个坑,这时不要忘了初始化每一个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i]=new EmpLinkedList();
        }

    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id，得到该员工应当添加到哪条链表、
        int empLinkedListNo = hashFun(emp.getId());
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);

    }
    //遍历所有链表,遍历hashtab
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id，查找雇员
    public void findEmpById(int id){
        //使用散列函数，确定到那条链表查找
        int empLinkedListNo=hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null) {//找到了
            System.out.println("在第"+(empLinkedListNo+1)+"条链表中找到了雇员 id="+emp.getId());
        }else{
            System.out.println("在哈希表中没有找到该雇员~");
        }
    }

    //编写一个散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }
}
