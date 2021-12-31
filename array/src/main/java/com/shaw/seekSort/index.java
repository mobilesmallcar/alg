package com.shaw.seekSort;

import java.util.ArrayList;
import java.util.Arrays;

public class index {
    public static void main(String[] args){
//        String s = "abcde";
//        System.out.println(s.substring(0,2)+" "+s.substring(2));
        for(int i=0;i<=7;i++){
            System.out.println(i%7);
        }
    }
}
class Emp{
    protected int id;
    protected String name;
    protected Emp next = null;
    protected Emp(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}
class HashTab{
    public EmployLinkedList[] employLinkedListArray;
    private int size;
    public HashTab(int size){
        this.size = size;
        this.employLinkedListArray = new EmployLinkedList[size];
    }
}
class EmployLinkedList{
    private Emp head = null;
    //添加
    public void add(Emp emp){
        if(head == null){
            head = emp;
            return ;
        }
        Emp temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = emp;
    }
    public void list(int i){
        if(head == null){
            System.out.println("第"+i+"条链表为空");
            System.out.println();
            return ;
        }
        Emp temp = head;
        System.out.println("第"+i+"条链表内的数据为:");
        while(temp!=null){
            System.out.println(temp+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public Emp findEmpById(int id){
        if(head==null){
            return null;
        }
        Emp temp = head;
        while(temp!=null){
            if(temp.id == id){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    //遍历
    //查找一个
}
