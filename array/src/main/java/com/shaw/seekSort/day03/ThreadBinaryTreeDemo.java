package com.shaw.seekSort.day03;

/**
 * @author: xsy
 * @Date: 2022/1/5
 * @description: the concrete steps see to:{@link }
 */
//中序线索二叉树：(心得理解)实际就是一个建立一个双向的过程，从中序遍历第一个节点（最左边的节点）,到最后一个节点(最右边一个节点)
// -------> 1.处理左子树
// -------> 2.处理当前节点: 处理当前节点的左节点；处理当前节点的上级节点; 赋值上级节点
// -------> 3.处理右子树
//todo -->还欠缺后序线索化二叉树
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
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
        tree.postOrder();
        tree.preSearch(5);
        //开始编写
        //先编写中序线索二叉树
        tree.infixThreadTree(root);
        System.out.println("后继遍历中序线索化二叉树开始:");
        tree.infixThreadList1(root);
        System.out.println("=====================================");
        tree.infixThreadListOverWrite(root);
        System.out.println("前驱遍历中序线索化二叉树开始:");
        tree.infixThreadList2(root);
//        //=================================
//        tree.preThreadTree(root);
//        System.out.println("后继遍历前序线索化二叉树开始:");
//        tree.preThreadList(root);
    }
}

class ThreadBinaryTree {
    private HeroNode root;
    private HeroNode preNode;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        this.root.preOrder();
        printEnd();
    }

    public void infixOrder() {
        this.root.infixOrder();
        printEnd();
    }

    public void postOrder() {
        this.root.postOrder();
        printEnd();
    }

    public void preSearch(int no) {
        this.root.preSearch(no);
        printEnd();
    }

    public void printEnd() {
        System.out.println("=====================================");
    }

    /**
     * 通过中序线索化二叉树
     *
     * @param node
     */
    public void infixThreadTree(HeroNode node) {
        if (node == null) {
            return;
        }
        infixThreadTree(node.left);
        //判断当前节点的
        if (node.left == null) {
            node.left = preNode;
            node.isLeftThread = true;
        }
        if (preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.isRightThread = true;
        }
        preNode = node;
        infixThreadTree(node.right);
    }

    /**
     * 通过后继方式遍历，找到左节点
     */
    public void infixThreadList1(HeroNode node) {
        while (node.left != null && !node.isLeftThread) {
            node = node.left;
        }
        while (node != null) {
            System.out.println(node + ",");

            //如果右指针是线索
            if (node.isRightThread) {//为线索的条件是当前节点的右节点为空，看前面中序线索化对preNode的操作
                node = node.right;
            } else {
                node = node.right;
                while (node != null && !node.isLeftThread) {//如果当前节点不为空，
                    // isLeftThread为默认的 =>!isLeftThread true，说明下面还有就继续进行遍历
                    node = node.left;
                }
            }
        }
    }

    /**
     * 简化 方法->>infixThreadList1 的while循环写法
     * @param node
     */
    public void infixThreadListOverWrite(HeroNode node){
        while(node != null){
            while(!node.isLeftThread){
                node = node.left;
            }
            System.out.println(node+",");
            while(node.isRightThread){
                node = node.right;
                System.out.println(node+",");
            }
            node = node.right;
        }
    }

    /**
     * 通过前驱方式遍历，找到右节点
     */
    public void infixThreadList2(HeroNode node) {
        while (node.right != null && !node.isRightThread) {
            node = node.right;
        }
        while (node != null) {
            System.out.println(node + ",");

            if (node.isLeftThread) {
                node = node.left;
            } else {
                node = node.left;
                while (node != null && !node.isRightThread) {
                    node = node.right;
                }
            }
        }
    }

    /**
     * 通过前序生成二叉树
     *
     * @param node
     */
    public void preThreadTree(HeroNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null) {
            node.left = preNode;
            node.isLeftThread = true;
        }
        if (preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.isRightThread = true;
        }
        preNode = node;
        if (!node.isLeftThread) {
            preThreadTree(node.left);
        }
        if (!node.isRightThread) {
            preThreadTree(node.right);
        }
    }

    /**
     * 通过前序遍历二叉树
     *
     * @param node
     */
    public void preThreadList(HeroNode node) {
        while (node != null) {
            while (!node.isLeftThread) {
                System.out.println(node + ",");
                node = node.left;
            }
            System.out.println(node + ",");
            node = node.right;
        }
    }
}

class HeroNode {
    public HeroNode left;
    public HeroNode right;
    public int no;
    public String name;

    boolean isLeftThread = false;
    boolean isRightThread = false;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void preOrder() {
        print();
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        this.print();
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        this.print();
    }

    public void preSearch(int no) {
        if (no == this.no) {
            System.out.println(this);
            return;
        }
        if (this.left != null) {
            this.left.preSearch(no);
        }
        if (this.right != null) {
            this.right.preSearch(no);
        }
    }

    public void print() {
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
