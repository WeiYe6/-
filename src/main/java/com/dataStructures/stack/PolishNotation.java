package com.dataStructures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolishNotation { //逆波兰表达式
    public static void main(String[] args) {
        //先定义逆波兰表达式
        //(3+4)*5-6 -----> 3 4 + 5 * 6 = 29
        String reverseExpression = "3 4 + 5 * 6 -";
        int result = calculate(getString(reverseExpression));
        System.out.println("结果:" + result);

    }

    //把表达式存入List中
    public static List<String> getString(String expression) {
        //去空格:以空格来分割每个字符
        String[] split = expression.split(" ");
        return new ArrayList<>(Arrays.asList(split)); //如果你的List只是用来遍历，就用Arrays.asList()。（数组---》集合）
    }

    //计算: 传入表达式进行计算
    public static int calculate(List<String> list) {
        /*
         * 从左至右扫描，将3和4压入堆栈；
         * 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
         * 将5入栈；
         * 接下来是*运算符，因此弹出5和7，计算出7*5=35，将35入栈；
         * 将6入栈；
         * 最后是-运算符，计算出35-6的值，即29，由此得出最终结果
         */
        //先创建一个栈
        Stack<Integer> stack = new Stack<>();
        //对表达式进行遍历(扫描)
        for (String s : list) {
            //正则表达式：表示匹配一个或多个连续的数字
            if (s.matches("\\d+")) {
                //数字直接入栈
                stack.push(Integer.parseInt(s));
            } else {//符号
                int result = 0;//存结果
                //栈中弹出两个数，进行计算（后弹出的 - 前弹出的）
                int num1 = stack.pop();
                int num2 = stack.pop(); //后弹出的
                switch (s) {
                    case "+": //注意：此时s为符号
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                    default:
                        System.out.println("输入的符号有误!");
                        break;
                }
                stack.push(result);
            }
        }
        //将结果弹出
        return stack.pop();
    }
}
