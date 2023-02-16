package com.shemengxin.java.huffman.huffmancode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        List<Node> nodes = HuffmanCode.getNodes(contentBytes);
        System.out.println(nodes);

        Node root = HuffmanCode.createHuffmanTree(nodes);
        HuffmanCode.preOrder(root);
    }
}
