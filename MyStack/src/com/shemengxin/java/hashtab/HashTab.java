package com.shemengxin.java.hashtab;

/**
 * ����HashTab�����������
 */
public class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;//���ж���������

    //������
    public HashTab(int size) {
        this.size = size;
        //��ʼ��empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //��һ����,��ʱ��Ҫ���˳�ʼ��ÿһ������
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i]=new EmpLinkedList();
        }

    }

    //��ӹ�Ա
    public void add(Emp emp) {
        //����Ա����id���õ���Ա��Ӧ����ӵ���������
        int empLinkedListNo = hashFun(emp.getId());
        //��emp��ӵ���Ӧ��������
        empLinkedListArray[empLinkedListNo].add(emp);

    }
    //������������,����hashtab
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //���������id�����ҹ�Ա
    public void findEmpById(int id){
        //ʹ��ɢ�к�����ȷ���������������
        int empLinkedListNo=hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null) {//�ҵ���
            System.out.println("�ڵ�"+(empLinkedListNo+1)+"���������ҵ��˹�Ա id="+emp.getId());
        }else{
            System.out.println("�ڹ�ϣ����û���ҵ��ù�Ա~");
        }
    }

    //��дһ��ɢ�к�����ʹ��һ���򵥵�ȡģ��
    public int hashFun(int id) {
        return id % size;
    }
}
