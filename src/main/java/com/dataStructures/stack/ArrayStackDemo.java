package com.dataStructures.stack;

import java.lang.reflect.Array;

/**
 * 数组模拟栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
       /* //测试
        ArrayStack stack = new ArrayStack(5);
        stack.list();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);//(异常)
        stack.list();
        System.out.println("出栈的元素:"+stack.pop());
        System.out.println("出栈的元素:"+stack.pop());
        System.out.println("出栈的元素:"+stack.pop());
        System.out.println("出栈的元素:"+stack.pop());
        System.out.println("出栈的元素:"+stack.pop());
        System.out.println("出栈的元素:"+stack.pop());//(异常)
        stack.list();*/


        //首先创建两个栈，一个用于存放数字，一个用于存放符号
        ArrayStack numBerStack = new ArrayStack(10); //数字栈
        ArrayStack operateStack = new ArrayStack(10); //符号栈
        //要计算的式子
        String s = "70-3*2+1";
        String keepNum = "";//用于拼接多位数的
        int index = 0; //用于扫描的
        //两个用于操作的数
        int num1 = 0;
        int num2 = 0;
        //运算符
        int operate = 0;
        //要存入的字符
        char ch = ' ';//每次扫描都存到ch中
        //结果
        int res = 0;
        //开始扫描
        do {
            //查看s中每一个字符
            ch = s.substring(index, index + 1).charAt(0);//一个一个取
            //判断ch是什么如果是一个运算符就做相应的操作
            if (operateStack.isOperate(ch)) { //是运算符
                if (!operateStack.isEmpty()) {//符号栈 如果不为空做相应的操作
                    //首先先判断符号的优先级,如果大于之前的运算符就直接放入，反之的话就先pop出一个符号和两个数进行运算；
                    int priority = operateStack.priority(ch); //判断待加入符号的优先级
                    if (priority <= operateStack.priority((char) operateStack.showTop())) {
                        //当前运算符的优先级 小于等于 栈中符号的优先级(数栈取出两个数 符号栈取出一个符号，进行计算，结果放回数栈，待进入的符号进符号栈)
                        num1 = numBerStack.pop();
                        num2 = numBerStack.pop();
                        operate = operateStack.pop();
                        res = numBerStack.Cal(num1, num2, (char) operate);//进行计算
                        numBerStack.push(res);
                        operateStack.push(ch);// char 类型可以被隐式地转换为 int 类型 保存char 字符对应的ASCII值
                    } else {
                        //当前运算符的优先级 大于 栈中符号的优先级
                        operateStack.push(ch);
                    }
                } else {
                    //为空,直接加入
                    operateStack.push(ch);
                }
            } else {//非运算符数字->直接入数栈: ASCII码对应的值是49 所以ch - 48：为字符所对应的数字
                //numBerStack.push(ch - 48);（这里的问题分析与解决）
                /*
                分析：这里的问题当出现的不是一位数比如：70,就不能以70存进栈中，而是 7  和 0 分开存，所以不能进行多位数的运算。
                解决：1创建一个变量 来进行字符串拼接
                     2.判断表示式 当index扫描到后面不是字符时，就不能入栈，而是把该数字与前一个数字进行拼接
                     3.扫描到index后为字符时，就整体 入数栈
                 */
                keepNum = keepNum + ch;
                if (index == s.length() - 1) {// 到表达式最后一个 肯定是数字，直接入栈
                    numBerStack.push(Integer.parseInt(keepNum));
                } else {//非最后一个字符：要进行判断：往index后看一下如果是运算符直接将前面的数入栈
                    if (operateStack.isOperate(s.substring(index + 1, index + 2).charAt(0))) {
                        numBerStack.push(Integer.parseInt(keepNum));
                        //重置keepNum
                        keepNum = "";
                    }
                }
            }
            index++;//判断是否扫描完成
        } while (index < s.length());
        //当表示式扫描完成后，就依次获取（pop）数字和符号进行计算并运算
        while (!operateStack.isEmpty()) {
            //如果符号栈为空，则计算到最后的结果,数栈中只有一个数字（结果）
            num1 = numBerStack.pop();
            num2 = numBerStack.pop();
            operate = operateStack.pop();
            res = numBerStack.Cal(num1, num2, (char) operate);
            numBerStack.push(res);//入栈
        }
        System.out.printf("表达式%s = %d", s, numBerStack.pop());
    }
}

class ArrayStack { //栈
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈，用来存放数据
    private int top = -1; //表示栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];//初始化数组
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //判断栈是否满
        if (isFull()) {
            System.out.println("栈满了，无法入栈");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈(返回出栈的元素)
    public int pop() {
        //判断栈是否空
        if (isEmpty()) {
            throw new RuntimeException("栈空,没有数据");
        }
        int temp = stack[top];
        top--;
        return temp;
    }

    //遍历（从栈顶往下遍历）
    public void list() {
        //判断是否为空
        if (isEmpty()) {
            System.out.println("栈为空,没有数据可以遍历");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("Stack[%d]=%d", i, stack[i]);
            System.out.println();
        }
    }

    //设置每个符号的优先级:人为设置:数字高的优先
    public int priority(char operate) {
        if (operate == '*' || operate == '/') {
            return 1;
        } else if (operate == '+' || operate == '-') {
            return 0;
        } else {
            return -1; //目前只有 + - * /
        }
    }

    //判断是不是一个运算符
    public boolean isOperate(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    //计算方法
    public int Cal(int num1, int num2, char operate) {
        int res = 0;
        switch (operate) {
            case '*':
                res = num1 * num2;
                break;
            case '-':
                res = num2 - num1;//被减数先入栈，减数后入栈，所以要后面的减前面的
                break;
            case '/':
                res = num2 / num1;
                break;
            case '+':
                res = num1 + num2;
                break;
            default:
                System.out.println("特殊错误");
                break;
        }
        return res;
    }

    //增加一个方法可以看到栈顶的元素
    public int showTop() {
        return stack[top];
    }


}
