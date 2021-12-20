package com.shaw.org.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//如果是波兰表达式 就应该为  - + * 5 3 4 17 ？？对吗 待验证..
//逆波兰表达式
public class PolandNotion {
    public static void main(String[] args){
        String suffixExpression = "3 4 + 5 * 17 -";
        List<String> req =  getListString(suffixExpression);
        System.out.println("计算结果为:"+Calculator(req));
    }
    public static List<String> getListString(String expression){
        String[] list = expression.split(" ");
        List<String> res = new ArrayList<>(Arrays.asList(list));
        return res;
    }
    public static int Calculator(List<String> req){
        Stack<String> stack = new Stack<>();
        for(String s:req){
            if(s.matches("\\d+")){
                stack.push(s);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch(s){
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        break;
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
