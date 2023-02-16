package com.shemengxin.java.huffman.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * �շ�����
 *
 * �����һ������������������С�������򣬰�����������С��������ȡ���������������ĺ���Ϊһ������㣬
 * ���������ֱ�Ϊ����������Ȼ��������������������ɾ�����Ѹ��ڵ�������У��ڽ��д�С������������
 * �������ϲ�����ֱ��������ֻʣ���һ��ʱ���ʹ�������һ�źշ������ˡ�
 *
 */
public class HuffmanTree {

    //�Ժշ���������ǰ�����
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("����Ϊ�գ�");
        }
    }

    /**
     * �����շ�����
     * @param arr ��Ҫ�����ɺշ�����������
     * @return �����õ����ĸ����
     */
    public static Node createHuffmanTree(int[] arr) {
        //�������е���ת��Ϊ���
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //�������������Ա㴴���շ�����
            Collections.sort(nodes);

            //ȡ��Ȩֵ��С�����������������,����һ���µĶ�����
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.getValue() + right.getValue());
            parent.setLeft(left);
            parent.setRight(right);

            //��List���������������ɾ����������parent���
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);

            //Ȼ���ڼ������򣬽������ϲ�����ֱ��List�����еĽ����Ϊ1ʱ���շ������ʹ��������
        }

        //�����ĸ���㷵�ؼ���
        return nodes.get(0);
    }
}
