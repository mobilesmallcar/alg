package com.shaw.org.day01;

public class MyDoubleListTest {
    public static void main(String[] args){
        MyDoubleList list = new MyDoubleList();
        MyDoubleNode node1 = new MyDoubleNode("第一个节点","我一个属性，元老级");
        MyDoubleNode node2 = new MyDoubleNode("第二个节点","我两个属性，老和宝");
        MyDoubleNode node3 = new MyDoubleNode("第三个节点","我三个属性，我下还有小");
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.list();
        list.del(node2.name);
        list.list();
    }
}
class MyDoubleList{
    private MyDoubleNode initNode = new MyDoubleNode("双向链表","初始化的节点");
    public void add(MyDoubleNode node){
        MyDoubleNode cur = initNode;
        while(true){
            if(cur.next == null)
                break;
            cur = cur.next;
        }
        cur.next = node;
        node.pre = cur;
    }
    public void del(String name){
        MyDoubleNode cur = initNode;
        while(true){
            if(cur.next == null){
                System.out.println("无此节点");
                break;
            }
            if(cur.next.name.equals(name)){
                if(cur.next.next==null){
                    System.out.println("come in");
                    cur.next = null;
                }else{
                    //the follow can't revert
                    cur.next.next.pre = cur;
                    cur.next = cur.next.next;
                }
                System.out.println("删除成功");
                break;
            }
            cur = cur.next;
        }
    }
    public void list(){
        System.out.println("---------遍历开始--------");
        MyDoubleNode cur = initNode;
        while(true){
            if(cur.next == null) {
                System.out.println("---------遍历结束--------");
                break;
            }
            cur = cur.next;
            System.out.println("前置节点:"+cur.pre+"\n\t当前节点:"+cur.name+","+cur+"\n\t后置节点:"+cur.next);
        }
    }
}
class MyDoubleNode{
    String name;
    MyDoubleNode pre;
    MyDoubleNode next;
    String attr;
    public MyDoubleNode(){

    }
    public MyDoubleNode(String name,String attr){
        this.name = name;
//        this.pre = pre;
//        this.next = next;
        this.attr = attr;
    }
}
