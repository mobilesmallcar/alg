package com.shaw.seekSort.day02;

import static com.shaw.seekSort.day02.BinaryTreeDemo.isNewLine;

/**
 * @author: xsy
 * @Date: 2021/12/31
 * @description: the structure of BinaryTree
 * the corresponding img is ./img/BinaryTree.png
 */
public class BinaryTreeDemo {
    public static final String isNewLine = "";//如果采用打印对象的方式这里填写\n，默认不填
    public static void main(String[] args) {
        // 先创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建需要的节点
        HeroNode root = new HeroNode(1,"A");
        HeroNode B = new HeroNode(2,"B");
        HeroNode C = new HeroNode(3,"C");
        HeroNode D = new HeroNode(4,"D");
        HeroNode E = new HeroNode(5,"E");
        HeroNode F = new HeroNode(6,"F");
        HeroNode G = new HeroNode(7,"G");
        HeroNode H = new HeroNode(8,"H");
        HeroNode I = new HeroNode(9,"I");

        // 这里先手动创建二叉树,后面采用递归优化
        root.left = B;
        root.right = C;

        B.left = D;
        B.right = E;

        D.left = F;
        D.right = G;

        G.left = H;
        G.right = I;
        binaryTree.setRoot(root);
        // 测试
        System.out.println("前序遍历: "); // A->B->D->F->G->H->I->E->C
        binaryTree.preOrder();
        System.out.println("\n中序遍历: "); // F->D->H->G->I->B->E->A->C
        binaryTree.infixOrder();
        System.out.println("\n后序遍历: "); // F->H->I->G->D->E->B->C->A
        binaryTree.postOrder();
        System.out.println();
    }
}
class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root = root;
    }

    public void preOrder(){
        this.callNode(1);
    }
    public void infixOrder(){
        this.callNode(2);
    }
    public void postOrder(){
        this.callNode(3);
    }
    private void callNode(int which){
        if(this.root != null){
            switch(which){
                case 1:
                    root.preOrder();
                    break;
                case 2:
                    root.infixOrder();
                    break;
                case 3:
                    root.postOrder();
                    break;
            }
        }else{
            System.out.println("二叉树为空 无法遍历");
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;

    public HeroNode(int no,String name){
        this.no = no;
        this.name = name;
    }
    //前序遍历
    public void preOrder(){
        this.print();
        //递归遍历左子树
        if(this.left != null){
            this.left.preOrder();
        }
        //递归遍历右子树
        if(this.right != null){
            this.right.preOrder();
        }
    }
    public void infixOrder(){
        //递归遍历左子树
        if(this.left != null){
            this.left.infixOrder();
        }
        this.print();
        //递归遍历右子树
        if(this.right != null){
            this.right.infixOrder();
        }
    }
    public void postOrder(){
        //递归遍历左子树
        if(this.left != null){
            this.left.postOrder();
        }
        //递归遍历右子树
        if(this.right != null){
            this.right.postOrder();
        }
        this.print();
    }
    public void print(){
        System.out.print(this+isNewLine);
    }
//    @Override
//    public String toString() {
//        return "HeroNode{" +
//                "no=" + no +
//                ", name='" + name + '\'' +
////                ", left=" + left +
////                ", right=" + right +
//                '}';
//    }
    @Override
    public String toString() {
        return   name +"->";
    }
}
