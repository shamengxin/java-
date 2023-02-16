package com.shemengxin.java.huffman.huffmancode;

import java.util.*;

/**
 * 赫夫曼编码
 */
public class HuffmanCode {

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("此树为空！");
        }
    }

    /**
     * 创建赫夫曼编码的结点
     *
     * @param bytes 需要变成结点的字符串
     * @return 结点集合
     */
    public static List<Node> getNodes(byte[] bytes) {

        ArrayList<Node> nodes = new ArrayList<Node>();

        //统计得到每个字符出现的次数
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //遍历map创建结点
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    /**
     * 创建赫夫曼树
     * @param nodes
     * @return
     */
    public static Node createHuffmanTree(List<Node> nodes){

        while (nodes.size() > 1) {
            //将结点进行排序，以便创建赫夫曼树
            Collections.sort(nodes);

            //取出权值最小的两棵树，进行组合,构成一颗新的二叉树
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(null,left.getWeight() + right.getWeight());
            parent.setLeft(left);
            parent.setRight(right);

            //将List集合中这两个结点删除，并加入parent结点
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);

            //然后在继续排序，进行如上操作，直到List集合中的结点数为1时，赫夫曼树就创建完成了
        }

        //将树的根结点返回即可
        return nodes.get(0);

    }
}
