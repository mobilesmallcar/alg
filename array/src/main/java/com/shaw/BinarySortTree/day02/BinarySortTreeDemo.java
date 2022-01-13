package com.shaw.BinarySortTree.day02;

import jdk.nashorn.internal.ir.IfNode;
import sun.reflect.generics.tree.Tree;

import java.awt.print.Pageable;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2, 11, 13};
        BinarySortTree tree = new BinarySortTree();
        for(int sub:arr){
            tree.add(new Node(sub));
        }
        tree.getRoot().infixOrder();
        System.out.println("删除节点后");
        //左右子节点皆存在的删除
//        tree.delNode(10);
//        tree.delNode(3);
        //右节点删除
//        tree.delNode(2);
        //左节点删除
//        tree.delNode(9);
        //只有右子节点的删除
        tree.delNode(1);
        tree.getRoot().infixOrder();
    }
}
class BinarySortTree{
    private Node root;
    public Node getRoot(){
        return this.root;
    }
    public void setRoot(Node node){
        this.root = node;
    }
    public void infixOrder(){
        if(this.root == null){
            System.out.println("当前节点无元素，不可遍历");
            return ;
        }else{
            this.root.infixOrder();
        }
    }
    public Node search(int value){
        if(this.root == null){
            return null;
        }else{
            return this.root.search(value);
        }
    }
    public Node searchParent(int value){
        if(this.root == null){
            return null;
        }else{
            return this.root.searchParent(value);
        }
    }
    public void add(Node node){
        if(this.root == null){
            this.root = node;
        }else{
            this.root.add(node);
        }
    }
    public void delNode(int value){
        if(this.root == null){
            return ;
        }else{
            if(this.root.left == null && this.root.right == null){
                this.root = null;
            }
            Node targetNode = this.search(value);
            Node parentNode = this.searchParent(value);
            if(targetNode.left == null && targetNode.right == null){
                if(parentNode.value >= targetNode.value){
                    parentNode.left = null;
                }else{
                    parentNode.right = null;
                }
            }else if(targetNode.left != null && targetNode.right != null){
                //删除右边最小
                int min = delMinNode(targetNode);
                targetNode.value = min;
            }else{
                if(targetNode.left != null){
                    if(parentNode.value >= targetNode.value){
                        parentNode.left = targetNode.left;
                    }else{
                        parentNode.right = targetNode.left;
                    }
                }else{
                    if(parentNode.value >= targetNode.value){
                        parentNode.left = targetNode.right;
                    }else{
                        parentNode.right = targetNode.right;
                    }
                }
            }
        }
    }

    private int delMinNode(Node node) {
        Node target = node.right;
        while(target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }
}
class Node{
    public int value;
    public Node left;
    public Node right;
    public Node(int value){
        this.value = value;
    }
    public void add(Node node){
        if(this.value >= node.value){
            if(this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else {
            if(this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
    }

    public Node search(int value){
        if(this.value == value){
            return this;
        }else if(this.value > value){
            if(this.left != null){
                return this.left.search(value);
            }else{
                return null;
            }
        }else{
            if(this.right != null){
                return this.right.search(value);
            }else{
                return null;
            }
        }
    }
    public Node searchParent(int value){
        if(this.left != null && this.left.value == value){
            return this;
        }else if(this.right != null && this.right.value == value){
            return this;
        }else{
            if(this.value > value && this.left != null){
                return this.left.searchParent(value);
            }else if(this.value < value && this.right != null){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
    }
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
//                ", left=" + left +
//                ", right=" + right +
                '}';
    }
}
