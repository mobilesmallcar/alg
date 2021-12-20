package com.shaw.org.day01;

public class MySingleListTest {
    public static void main(String[] args){
        MySingleList list = new MySingleList();
//        System.out.println(list);
        MyNode node = new MyNode("第一个节点");
        list.addNode(node);
        MyNode node2 = new MyNode("第二个节点");
        list.addNode(node2);
        list.addNode(new MyNode("第三个节点"));
        list.list();
        list.delNode("第二个节点");
        list.list();
        node.attr = "我有属性了";
        list.updateNode(node);
        list.list();
    }
}
class MySingleList{
    private MyNode initNode = new MyNode("myList",null);
    public void addNode(MyNode node){
        //the next is aim at null that means it is last.
        //first:attach the temp obj to headNode;
        MyNode temp = initNode;
        while(true){
            //Come in
            if(temp.next == null)
                break;
            temp = temp.next;
        }
        temp.next = node;
    }
    public void delNode(String name){
        MyNode temp = initNode;
        while(true){
            if(temp.next == null){
                System.out.println("未找到该名字的列表");
                break;
            }
            if(temp.next.name.equals(name)){
                temp.next = temp.next.next;
                System.out.println("删除成功");
                break;
            }
            temp = temp.next;
        }
    }
    public void updateNode(MyNode node){
        MyNode temp = initNode;
        while(true){
            if(temp.next == null){
                System.out.println("该节点不存在");
                break;
            }
            if(temp.next.name.equals(node.name)){
                temp.next.attr = node.attr;
                System.out.println("更新成功");
                break;
            }
            temp = temp.next;
        }
    }
    public void list(){
        MyNode temp = initNode;
        while(true){
            if(temp.next == null)
                break;
            System.out.println(temp.next.name+":"+temp.next.attr);
            temp = temp.next;
        }
    }
}
class MyNode{
    String name;
    MyNode next;
    String attr;
    public MyNode(){
    }
    public MyNode(String name){
        this.name = name;
        this.next = null;
    }
    public MyNode(String name,MyNode ndoe){
        this.name = name;
        this.next = ndoe;
    }

}
