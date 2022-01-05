package com.shaw.seekSort.day03;

/**
 * @author: xsy
 * @Date: 2022/1/5
 * @description:
 * the concrete steps see to:{@link }
 */
public class ThreadBinaryTreeDemo {
    public static void main(String[] args){
        ThreadBinaryTree tree = new ThreadBinaryTree();
        HeroNode root = new HeroNode(1, "A");
        HeroNode B = new HeroNode(2, "B");
        HeroNode C = new HeroNode(3, "C");
        HeroNode D = new HeroNode(4, "D");
        HeroNode E = new HeroNode(5, "E");
        HeroNode F = new HeroNode(6, "F");
        HeroNode G = new HeroNode(7, "G");
        HeroNode H = new HeroNode(8, "H");
        HeroNode I = new HeroNode(9, "I");

        // 这里先手动创建二叉树,后面采用递归优化
        root.left = B;
        root.right = C;

        B.left = D;
        B.right = E;

        D.left = F;
        D.right = G;

        G.left = H;
        G.right = I;
        tree.setRoot(root);
        tree.preOrder();
        tree.infixOrder();
        tree.postOrder();
        tree.preSearch(5);
        //开始编写

    }
}
class ThreadBinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root = root;
    }
    public void preOrder(){
        this.root.preOrder();
        printEnd();
    }
    public void infixOrder(){
        this.root.infixOrder();
        printEnd();
    }
    public void postOrder(){
        this.root.postOrder();
        printEnd();
    }
    public void preSearch(int no){
        this.root.preSearch(no);
    }
    public void printEnd(){
        System.out.println("=====================================");
    }
}
class HeroNode{
    public HeroNode left;
    public HeroNode right;
    public int no;
    public String name;
    boolean isLeftThread = false;
    boolean isRightThread = false;

    public HeroNode(int no,String name){
        this.no = no;
        this.name = name;
    }
    public void preOrder(){
        print();
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        this.print();
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        this.print();
    }

    public void preSearch(int no) {
        if(no==this.no){
            System.out.println(this);
            return;
        }
        if(this.left!=null){
            this.left.preSearch(no);
        }
        if(this.right!=null){
            this.right.preSearch(no);
        }
    }

    public void print(){
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


}
