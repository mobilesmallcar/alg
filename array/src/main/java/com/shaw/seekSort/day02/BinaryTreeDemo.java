package com.shaw.seekSort.day02;


import static com.shaw.seekSort.day02.BinaryTreeDemo.isNewLine;

/**
 * @author: xsy
 * @Date: 2021/12/31
 * @description: the structure of BinaryTree
 * the corresponding img is ./img/BinaryTree.png
 */
public class BinaryTreeDemo {
    public static String isNewLine = "";//是否换行

    public static void main(String[] args) {
        // 先创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建需要的节点
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
        binaryTree.setRoot(root);
        // 测试
        System.out.println("前序遍历: "); // A->B->D->F->G->H->I->E->C
        binaryTree.preOrder();
        System.out.println("\n中序遍历: "); // F->D->H->G->I->B->E->A->C
        binaryTree.infixOrder();
        System.out.println("\n后序遍历: "); // F->H->I->G->D->E->B->C->A
        binaryTree.postOrder();
        System.out.println();


        //查找
        HeroNode heroNode;
        heroNode = binaryTree.preOrderSearch(5);
//        heroNode = binaryTree.infixOrderSearch(10);
//        heroNode = binaryTree.postOrderSearch(5);
        if (heroNode != null) {
            System.out.println("找到该节点 :" + heroNode.toString());
        } else {
            System.out.println("没有该节点哦");
        }

        //删除
        System.out.println("\n\n节点删除后,进行前序遍历:");
        binaryTree.delete(4);
        binaryTree.preOrder();
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        this.callNodeList(1);
    }

    public void infixOrder() {
        this.callNodeList(2);
    }

    public void postOrder() {
        this.callNodeList(3);
    }

    public HeroNode preOrderSearch(int no) {
        return this.callNodeSearch(1, no);
    }

    public HeroNode infixOrderSearch(int no) {
        return this.callNodeSearch(2, no);
    }

    public HeroNode postOrderSearch(int no) {
        return this.callNodeSearch(3, no);
    }

    public void delete(int no) {
        if (this.root == null) {
            System.out.println("节点都没有,删不了");
        } else {
            if (this.root.no == no) {
                root = null;
            } else {
                root.delete(no);
            }
        }
    }

    private void callNodeList(int which) {
        if (this.root != null) {
            switch (which) {
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
        } else {
            System.out.println("二叉树为空 无法遍历");
        }
    }

    private HeroNode callNodeSearch(int which, int no) {
        if (root != null) {
            switch (which) {
                case 1:
                    System.out.println("进入前序遍历查找:");
                    return root.preOrderSearch(no);
                case 2:
                    System.out.println("进入中序遍历查找:");
                    return root.infixOrderSearch(no);
                case 3:
                    System.out.println("进入后序遍历查找:");
                    return root.postOrderSearch(no);
                default:
                    throw new RuntimeException("非法请求");
            }
        } else {
            return null;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //前中后遍历
    public void preOrder() {
        this.print();
        //递归遍历左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归遍历右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        //递归遍历左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        this.print();
        //递归遍历右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        //递归遍历左子树
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归遍历右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        this.print();
    }

    //前中后搜索
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        return null;
    }

    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        return null;
    }

    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        return null;
    }

    public void delete(int no) {
        if (this.left != null && this.left.no == no){//左边退出条件
            this.left = null;
            return;
        }
        else if(this.right != null && this.right.no == no){//右边退出条件
            this.right = null;
            return;
        }else{
        if(this.left != null){
            this.left.delete(no);
        }
        if(this.right != null){
            this.right.delete(no);
        }}
    }

    public void print() {
        System.out.print(this + isNewLine);
    }

    @Override
    public String toString() {
        isNewLine = "\n";
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
//                ", left=" + left +
//                ", right=" + right +
                '}';
    }
//    @Override
//    public String toString() {
//        return   name +"->";
//    }
}

