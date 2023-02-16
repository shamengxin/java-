package com.shemengxin.java.huffman.huffmantree;

public class Test {
    public static void main(String[] args) {

        int[] arr = {13,7,8,3,29,6,1};

        Node root = HuffmanTree.createHuffmanTree(arr);
        HuffmanTree.preOrder(root);
    }
}
