package com.axhiao.aer.ch1;

import java.util.Stack;

public class ReverseStack {

    public static int getAndRemoveLast(Stack<Integer> stack) {
        int n = stack.pop();
        if (stack.empty()) {
            return n;
        }
        int last = getAndRemoveLast(stack);
        stack.push(n);
        return last;
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int n = getAndRemoveLast(stack);
        reverseStack(stack);
        stack.push(n);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        // test
        for(int s : stack) {
            System.out.println(s);
        }
        reverseStack(stack);
        System.out.println("==================");
        for(int s : stack) {
            System.out.println(s);
        }

    }

}
