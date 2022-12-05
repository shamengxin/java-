package com.shemengxin.java.linked;

/**
 * ��������ʵ��
 */
public class DLLinkedList {
    //ͷ�ڵ�
    private GoodsNode node=new GoodsNode(0,"",0.0);

    /**
     * ����������ӽ��
     * @param goodsNode
     */
    public void add(GoodsNode goodsNode){
        GoodsNode temp=node;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=goodsNode;
    }

    /**
     * ����id�Ĵ�С���в��룬����id�����ظ�
     * @param goodsNode
     */
    public void addOrder(GoodsNode goodsNode){
        GoodsNode temp=node;
        boolean flg=false;
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.id>goodsNode.id){
                break;
            }else if(temp.next.id==goodsNode.id){
                //����ж��Ƿ�ֹ��Ʒ�ظ���
                flg=true;
                break;
            }
            temp=temp.next;
        }

        if(flg){
            System.out.println("����Ʒ�Ѵ���,�����ظ����Ԫ�ء�");
        }else{
            goodsNode.next=temp.next;
            temp.next=goodsNode;
        }
    }

    /**
     * ����������޸�
     * @param goodsNode
     */
    public void updateNode(GoodsNode goodsNode){
        //�ж������Ƿ�Ϊ��
        if(node.next==null){
            System.out.println("����Ϊ�ա�");
            return;
        }

        GoodsNode temp=node.next;
        //���ڶ����Ƿ��ҵ��˽��
        boolean flg=false;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.id==goodsNode.id){
                flg=true;
                break;
            }

            temp=temp.next;
        }

        if(flg){
            temp.name=goodsNode.name;
            temp.price=goodsNode.price;
        }else{
            System.out.println("������������δ�ҵ�Ŀ���㡣");
        }

    }

    /**
     * id����Ψһ�ԣ�����id����ɾ�����
     * @param id
     */
    public void delNode(int id){
        GoodsNode temp=node;
        boolean flg=false;
        while(true){
            if(temp.next==null){
                break;
            }
            if(temp.next.id==id){
                flg=true;
                break;
            }
            temp=temp.next;
        }
        if(flg){
            temp.next=temp.next.next;
        }else{
            System.out.println("��id�����ڡ�");
        }
    }

    /**
     * ������������
     */
    public void list(){
        if(node.next==null){
            System.out.println("������Ϊ��");
            return;
        }
        GoodsNode temp=node.next;
        while(true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

    /**
     * ������
     * ���㵥�����д��ڵĽ�����
     * ��ͳ��ͷ�ڵ�
     */
    public int getLength(){
        if(node.next==null){
            System.out.println("������");
            return 0;
        }
        GoodsNode temp=node.next;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }

}
