package com.shaw.seekSort.day05;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    private static int[] arr = {13, 7, 8, 3, 29, 6, 1};
    public static void main(String[] args) {
        Node node = createHuffmanTree();
        preOrder(node);
    }
    /**
     * 前序遍历
     * 67 29 38 15 7 8 23 10 4 1 3 6 13
     */
    private static Node createHuffmanTree(){
        List<Node> nodes = new ArrayList<>();
        for(int sub:arr){
            nodes.add(new Node(sub));
        }
        Collections.sort(nodes);
        while(nodes.size()>1){
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.value+right.value);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);

            Collections.sort(nodes);

        }
        return nodes.get(0);
    }
    private static void preOrder(Node node){
        if(node==null){
            System.out.println("当前树为空 不可遍历");
            return ;
        }
        System.out.print(node.value+"\t");
        if(node.left!=null){
            preOrder(node.left);
        }
        if(node.right!=null){
            preOrder(node.right);
        }
    }
}

class Node implements Comparable<Node> {
    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}

