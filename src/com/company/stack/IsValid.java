package com.company.stack;

import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        String s = "()[{]}";
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid(s));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else {
                if (stack.isEmpty())
                    return false;
                char c = stack.pop();
                char match = getMatch(s.charAt(i));
                if (c != match)
                    return false;
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

    private char getMatch(char c) {
        if (c == ')')
            return '(';
        else if (c == ']')
            return '[';
        else if (c == '}')
            return '{';
        else
            return ' ';
    }
}
