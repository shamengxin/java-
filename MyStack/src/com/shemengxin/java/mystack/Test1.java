package com.shemengxin.java.mystack;

/**
 * ջ��Ӧ�ã��жϻ���
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(detecation("hello"));
        System.out.println(detecation("aba"));
    }

    public static  boolean detecation(String val){
        /**
         * ��ʼ��ջ����
         */
        ArrayStack arrayStack=new ArrayStack(10);

        /**
         * ��ȡ�ַ�������
         */
        int length=val.length();
        //���ַ�������ѹջ
        for(int i=0;i<length;i++){
            arrayStack.push(val.charAt(i));
        }

        /**
         * ȡ��ջ��Ԫ��
         */
        String newVal="";
        //�����arrayStack.length()�ŵ�forѭ���У���������һ���̶���ֵ������б仯��
        //���½������bug
        int length1=arrayStack.length();
        for(int i=0;i<length1;i++){
            //�ж�ջ�Ƿ�Ϊ��
            if(!arrayStack.isEmpty()){
                char pop=(char)arrayStack.pop();
                newVal=newVal+pop;
            }
        }

        if(val.equals(newVal)){
            return true;
        }else {
            return false;
        }
    }
}
