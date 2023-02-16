package com.shemengxin.java.huffman.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 *
 * 如果有一组数，把这组数按从小到大排序，把这组数的最小的两个数取出，将这两个数的和作为一个根结点，
 * 这两个数分别为左右子树，然后将这两个数从这组书中删除，把根节点加入其中，在进行从小到大排序，往复
 * 进行如上操作，直到这组数只剩最后一个时，就创建出来一颗赫夫曼树了。
 *
 */
public class HuffmanTree {

    //对赫夫曼树进行前序遍历
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("此树为空！");
        }
    }

    /**
     * 创建赫夫曼树
     * @param arr 需要创建成赫夫曼树的数组
     * @return 创建好的树的根结点
     */
    public static Node createHuffmanTree(int[] arr) {
        //将数组中的数转化为结点
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //将结点进行排序，以便创建赫夫曼树
            Collections.sort(nodes);

            //取出权值最小的两棵树，进行组合,构成一颗新的二叉树
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.getValue() + right.getValue());
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
