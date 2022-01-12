package com.shaw.BinarySortTree.day01;

/**
 * @author: xsy
 * @Date: 2022/1/12
 * @description: the BinaryTree is sorted;
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 9,7, 3, 10, 12,4, 5, 1};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int a : arr) {
            binarySortTree.add(new Node(a));
        }
        binarySortTree.getRoot().infixOrder();
    }
}
// 创建二叉排序树
class BinarySortTree{
    private Node root;
    public void setRoot(Node node){
        this.root = node;
    }
    public Node getRoot(){
        return this.root;
    }
    public void infixOrder(Node node){
        if(node==null){
            return ;
        }else{
            node.infixOrder();
        }
    }
    public void add(Node node){
        if(root==null){
            root = node;
            return ;
        }else{
            root.add(node);
        }
    }
}

// 创建节点
class Node{
    public int value;
    public Node left;
    public Node right;
    public Node(int value){
        this.value = value;
    }
    public void add(Node node){
        if(node.value>this.value){
            if(this.right==null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }else{
            if(this.left==null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }
    }
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}

