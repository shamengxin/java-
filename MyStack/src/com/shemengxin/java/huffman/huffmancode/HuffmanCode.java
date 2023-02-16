package com.shemengxin.java.huffman.huffmancode;

import java.util.*;

/**
 * �շ�������
 */
public class HuffmanCode {

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("����Ϊ�գ�");
        }
    }

    /**
     * �����շ�������Ľ��
     *
     * @param bytes ��Ҫ��ɽ����ַ���
     * @return ��㼯��
     */
    public static List<Node> getNodes(byte[] bytes) {

        ArrayList<Node> nodes = new ArrayList<Node>();

        //ͳ�Ƶõ�ÿ���ַ����ֵĴ���
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //����map�������
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    /**
     * �����շ�����
     * @param nodes
     * @return
     */
    public static Node createHuffmanTree(List<Node> nodes){

        while (nodes.size() > 1) {
            //�������������Ա㴴���շ�����
            Collections.sort(nodes);

            //ȡ��Ȩֵ��С�����������������,����һ���µĶ�����
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(null,left.getWeight() + right.getWeight());
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
