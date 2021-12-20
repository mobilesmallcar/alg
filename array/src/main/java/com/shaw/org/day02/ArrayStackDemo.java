package com.shaw.org.day02;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack =new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.list();
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.list();
    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //push
    public void push(int num) {
        //insert a obj into the top
        if (isFull()) {
            throw new RuntimeException("栈满,添加元素失败");
        }
        stack[++top] = num;
    }

    //pop
    public int pop(){
        //get a num from the top of stack
        if(isEmpty()){
            throw new RuntimeException("栈空,不可再取出元素");
        }
        return stack[top--];
    }
    //栈满
    public boolean isFull() {
        return top == (maxSize - 1);
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //遍历
    public void list(){
        int temp = top;
        System.out.println("==================遍历开始===================");
        while(!isEmpty()){
            System.out.println("栈的第"+top+"个元素,值为:"+stack[top--]);
        }
        System.out.println("==================遍历结束===================");
        top = temp;
    }
}
