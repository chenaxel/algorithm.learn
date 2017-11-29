package com.axel.chapter1.learn.calculate;

import java.util.Stack;

/**
 * 双栈操作实现计算基本的算数表达式(Invented by E.W.Dijkstra),同样适用与有sqrt等函数
 *
 * 主要思想:
 *  1.忽略左括号
 *  2.将操作数和操作符分别入栈
 *  3.每碰到一个右括号，弹出2个操作数一个操作符，计算结果入栈
 *  4.总的表达式值为操作数栈的唯一元素
 */
public class Calculate {

    public static int calculate(String text) {

        if (null != text) {
            char[] exercise = text.toCharArray();
            Stack<Integer> number = new Stack<>();
            Stack<String> operation = new Stack<>();
            for (char ch : exercise) {
                if (String.valueOf(ch).equals("(")) ;
                else if (String.valueOf(ch).equals("+")) {
                    operation.push(String.valueOf(ch));
                } else if (String.valueOf(ch).equals("-")) {
                    operation.push(String.valueOf(ch));
                } else if (String.valueOf(ch).equals("*")) {
                    operation.push(String.valueOf(ch));
                } else if (String.valueOf(ch).equals("/")) {
                    operation.push(String.valueOf(ch));
                } else if (String.valueOf(ch).equals(")")) {
                    int value = number.pop();
                    String ops = operation.pop();
                    if (ops.equals("+")) {
                        number.push(value + number.pop());
                    } else if (ops.equals("-")) {
                        number.push(value - number.pop());
                    } else if (ops.equals("*")) {
                        number.push(value * number.pop());
                    } else {
                        number.push(value / number.pop());
                    }
                } else {
                    number.push(Integer.parseInt(String.valueOf(ch)));
                }
            }
            return number.pop();
        }
        return 0;
    }

    public static void main(String[] args) {
        String test = "(1+((2+3)*(4*5)))";
        System.out.println(calculate(test));
    }
}
