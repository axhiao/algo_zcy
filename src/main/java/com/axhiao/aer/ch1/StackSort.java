package com.axhiao.aer.ch1;

import java.util.Stack;

public class StackSort {

    public static void stackSort(Stack<Integer> stack) {
        if (stack == null || stack.empty()) {
            return;
        }
        Stack<Integer> help = new Stack<>();
        help.push(stack.pop());
        while(!stack.empty()) {
            int curr = stack.pop();
            if (curr > help.peek()) {
                while (!help.empty() && curr > help.peek()) {
                    stack.push(help.pop());
                }
            }
            help.push(curr);
        }

        while(!help.empty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // 5 3 2 3 1 4
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);

        stackSort(stack);
        while(!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
