package com.axel.chapter1.problem;

import com.axel.chapter1.learn._stack.LinkedStack;

/**
 * Created by ChenAxel on 2017/12/3.
 */
public class Parentheses {

    public static Boolean detect(String options) {

        if (null == options || "".equals(options)) {
            return null;
        } else {
            LinkedStack<Character> parentheses = new LinkedStack();
            char[] option = options.toCharArray();
            for (char ch : option) {
                if (")".equals(String.valueOf(ch))) {
                    char c = parentheses.pop();
                    if ("(".equals(String.valueOf(c))) {
                    } else {
                        return false;
                    }
                } else if ("]".equals(String.valueOf(ch))) {
                    char c = parentheses.pop();
                    if ("[".equals(String.valueOf(c))) {
                    } else {
                        return false;
                    }
                } else if ("}".equals(String.valueOf(ch))) {
                    char c = parentheses.pop();
                    if ("{".equals(String.valueOf(c))) {
                    } else {
                        return false;
                    }
                } else {
                    parentheses.push(ch);
                }
            }
            return parentheses.size() == 0;
        }
    }

    public static void main(String[] args) {

        String test = "[()]{}";
        System.out.println(detect(test));
    }
}
