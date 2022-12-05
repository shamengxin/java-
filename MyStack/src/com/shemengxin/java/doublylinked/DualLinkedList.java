package com.shemengxin.java.doublylinked;

public class DualLinkedList {
    private  BookNode head =new BookNode(0,"",0.0);

    /**
     * ��ӽ�β�µĽ��
     */
    public void addLast(BookNode newNode){
        BookNode temp=head;
        while (true){
            //�����һ�ξͽ��룬���ʾ˫�������ǿ�����
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        /**
         * ��Ҫ���µĽڵ����һ���ڵ�
         * ��Ҫ����һ�����nextָ���µĽ��
         */
        temp.next=newNode;
        newNode.pre=temp;
    }

    /**
     * �޸Ľڵ�
     * ������˫�������е�ÿһ���ڵ�ĺ��޸ĵ�id�Աȣ�����Աȳɹ�����Դ˽ڵ�����޸ģ�
     * ���δ�Աȳɹ���˫������δ�ҵ�Ŀ��ڵ�
     */
    public void updateNode(BookNode node){
        //�Ƿ��ǿ�����
        if(head.next==null){
            System.out.println("����Ϊ�գ�");
            return;
        }
        BookNode temp=head.next;
        boolean flg=false;
        while (true){
            if(temp==null){
                break;
            }
            if(temp.id==node.id) {
                flg = true;
                break;
            }
            temp=temp.next;
        }
        if(flg){
            temp.name=node.name;
            temp.price=node.price;
        }else{
            System.out.println("δ�ҵ�����Ŀ�꣡");
        }
    }

    /**
     * ˫�������ɾ��
     * ����������id��Ž��нڵ�ɾ��
     */
    public void delNode(int id){
        if(head.next==null){
            System.out.println("����Ϊ�գ�");
            return;
        }
        BookNode temp=head.next;
        boolean flg=false;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.id==id){
                flg=true;
                break;
            }
            temp=temp.next;
        }
        if(flg){
            temp.pre.next=temp.next;
            //ע�⣺Ҫ�жϺ�һ���ڵ��Ƿ�Ϊ��
            if(temp.next!=null) {
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("δ�ҵ�ɾ��Ŀ�꣡");
        }
    }
}
