package com.shaw.BinarySortTree.day03;

/**
 * @author: xsy
 * @Date: 2022/1/13
 * @description: the AVL Tree
 * the concrete steps see to:./img/AVL-LR.png
 */
public class BinaryBalanceTree {
    private static int[] arr = {10, 11, 7, 6, 8, 9};
    private static int len = arr.length;

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        for (int sub : arr) {
            avlTree.add(new Node(sub));
        }
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("树的高度=" + avlTree.getRoot().height());//3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight());//2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight());//2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8
    }
}

class AVLTree {
    private Node root;

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return this.root;
    }

    public void add(Node node) {
        if (root == null) {
            this.root = node;
        } else {
            this.root.add(node);
        }
    }

    public void infixOrder() {
        if (root == null) {
            System.out.println("当前不可遍历");
            return;
        } else {
            this.root.infixOrder();
        }
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    private void leftRotate(){
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        left = newNode;
        right = right.right;
    }
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (this.value >= node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        if (rightHeight() - leftHeight() > 1) {
            if(right.leftHeight()>right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else{
                leftRotate();
            }
            return ;
        }
        if(leftHeight() - rightHeight() > 1){
            if(left.rightHeight()>left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }else{
                rightRotate();
            }
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
