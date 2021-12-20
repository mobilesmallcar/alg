package com.shaw.org.day02;

public class Calculator {
    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
//        expression.
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 opeStack = new ArrayStack2(10);
        //遇到操作符才计算，当这次操作符优先级大于之前存入的操作符，继续入栈，（如果小于等于,取出两位数字，和栈顶操作符进行计算，再入栈操作符)
        //如果是数字 ,如果是最后一位则直接入栈，(在循环外部进行一次计算)，如果不是最后一位\
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int ope = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            ch = expression.charAt(index);
            if (opeStack.isOpe(ch)) {
                if (opeStack.isEmpty()) {
                    opeStack.push(ch);
                }
                else {
                    if (opeStack.priority(ch) <= opeStack.priority(opeStack.peak())) {
                        num2 = numStack.pop();
                        num1 = numStack.pop();
                        ope = opeStack.pop();
                        res = opeStack.cal(num1, num2, ope);
                        numStack.push(res);
                        opeStack.push(ch);
                    } else {
                        opeStack.push(ch);
                    }
                }
            }
            else {
                keepNum += ch;

                if (index == expression.length() - 1) {
                    System.out.println((int)ch);
                    numStack.push(ch-48);
                } else {
                    if (opeStack.isOpe(expression.charAt(index + 1))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        System.out.println("遍历完成");
        while(true){
            if(opeStack.isEmpty()){
                break;
            }
            num2 = numStack.pop();
            num1 = numStack.pop();
            ope = opeStack.pop();
            res = opeStack.cal(num1,num2,ope);
            numStack.push(res);
        }
        System.out.println(expression+" = "+numStack.peak());
    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public Boolean isFull() {
        return top == (maxSize - 1);
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public void push(int num) {
        if (isFull()) {
            throw new RuntimeException("栈满,添加元素失败");
        }
        stack[++top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，不可再取出元素");
        }
        return stack[top--];
    }

    public void list() {
        int temp = top;
        System.out.println("==================遍历开始===================");
        while (!isEmpty()) {
            System.out.println("栈的第" + top + "个元素为" + stack[top--]);
        }
        System.out.println("==================遍历结束===================");
        top = temp;
    }

    public boolean isOpe(char ope) {
        return ope == '+' || ope == '-' || ope == '*' || ope == '/';
    }

    public int cal(int num1, int num2, int ope) {
        int res = 0;
        switch (ope) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }

    //查看顶部元素
    public int peak() {
        return stack[top];
    }

    public int priority(int ch) {
        if (ch == '+' || ch == '-') {
            return 0;
        } else if (ch == '*' || ch == '/') {
            return 1;
        } else {
            throw new RuntimeException("不支持操作");
//            return -1;
        }
    }
}
