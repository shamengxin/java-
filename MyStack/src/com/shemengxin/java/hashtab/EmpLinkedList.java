package com.shemengxin.java.hashtab;

/**
 * ����EmpLinkedList,��ʾ����
 */
public class EmpLinkedList {
    //ͷָ�룬ִ�е�һ��Emp�����������������head ��ֱ��ָ���һ��Emp
    private Emp head;//Ĭ��null

    //��ӹ�Ա������
    //˵����
    //1.�ٶ�������ӹ�Աʱ��id�������ģ���id�ķ������Ǵ�С����
    //  ������ǽ��ù�Աֱ�Ӽ��뵽���������󼴿�
    public void add(Emp emp) {
        //�������ӵ�һ����Ա
        if (head == null) {
            head = emp;
            return;
        }
        //������ǵ�һ����Ա����ʹ��һ��������ָ�룬������λ�����
        Emp curEmp =head;
        while (true){
            if (curEmp.getNext() == null){//˵�����������
                break;
            }
            curEmp=curEmp.getNext();//����
        }
        //�˳�ʱֱ�ӽ�emp��������
        curEmp.setNext(emp);
    }

    //��������Ĺ�Ա��Ϣ
    public void list(int i){
        if(head==null){//˵������Ϊ��
            System.out.println("��"+(i+1)+"����Ϊ��");
            return;
        }
        System.out.print("��"+(i+1)+"�������ϢΪ��");
        Emp curEmp=head;//����ָ��
        while (true){
            System.out.print("=> id="+curEmp.getId()+"  name="+curEmp.getName()+"\t");
            if (curEmp.getNext()==null){//˵��curEmp�Ѿ��������
                break;
            }
            curEmp=curEmp.getNext();//���Ʊ���
        }
        System.out.println();
    }

    //����id���ҹ�Ա
    //������ҵ����ͷ���Emp�����û���ҵ����ͷ���null
    public Emp findEmpById(int id){
        //�ж������Ƿ�Ϊ��
        if(head==null){
            System.out.println("����Ϊ��");
            return null;
        }
        //����ָ��
        Emp curEmp=head;
        while (true){
            if (curEmp.getId()==id){//�ҵ���
                break;//��ʱcurEmp��ָ��Ҫ���ҵĹ�Ա
            }
            //�˳�
            if(curEmp.getNext()==null){//˵��������ǰ����û���ҵ��ù�Ա
                curEmp=null;
                break;
            }
            curEmp=curEmp.getNext();//����
        }
        return curEmp;
    }
}
