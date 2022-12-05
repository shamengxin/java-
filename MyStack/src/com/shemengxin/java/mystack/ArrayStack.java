package com.shemengxin.java.mystack;

/**
 * ջ
 */
public class ArrayStack {
    /**
     * ջ�Ĵ�С
     */
    private int maxStack;

    /**
     * ��������ģ��ջ
     */
    private int[] stack;

    /**
     * ʹ��topָ��ջ��λ�ã�Ĭ��Ϊ-1
     */
    private int top=-1;

    public ArrayStack(int maxStack){
        this.maxStack=maxStack;
        stack=new int[maxStack];
    }

    /**
     * �ж��Ƿ��Ѿ���ջ
     */
    public boolean isFull(){
        return this.top==this.maxStack-1;
    }

    /**
     * �ж�ջ�Ƿ�Ϊ��
     */
    public boolean isEmpty(){
        return this.top==-1;
    }

    /**
     * ѹջ
     */
    public void push(int val){
        //�ж��Ƿ�ջ��
        if(isFull()){
            throw new RuntimeException("��ջ����");
        }
        stack[++top]=val;
    }

    /**
     * ��ջ
     */
    public int pop(){
        //�ж�ջ�Ƿ�Ϊ��
        if(isEmpty()){
            throw new RuntimeException("��ջ��δ�ҵ�����");
        }
        return stack[top--];
    }

    /**
     * �鿴ջ������Ԫ��
     */
    public void list(){
        //�ж�ջ�Ƿ�Ϊ��
        if(isEmpty()){
            throw new RuntimeException("ջ�գ�δ�ҵ�����");
        }
        for (int i = 0; i <stack.length ; i++) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    /**
     * ջ��Ԫ�ظ���
     * @return
     */
    public int length(){
        return this.top+1;
    }

    /**
     * �ж��Ƿ���һ�������+ - * /
     */
    public boolean isOper(char v){
        return v=='+'||v=='-'||v=='*'||v=='/';
    }

    /**
     * �ж�����������ȼ���ʹ�����ֱ�ʾ���ȼ���С������Խ������ȼ�Խ��
     */
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;
        }

    }

    /**
     * ��ȡջ��Ԫ��
     */
    public int peek(){
        return this.stack[top];
    }

    /**
     * ��ȡջ������
     */
    public int stackLength(){
        return this.stack.length;
    }

    /**
     * �������������������Ľ��
     */
    public int calculate(int num1,int num2,int oper){
        //������
        int result=0;
        switch (oper){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num2-num1;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num2/num1;
                break;
            default:
                break;
        }
        return result;
    }
}
