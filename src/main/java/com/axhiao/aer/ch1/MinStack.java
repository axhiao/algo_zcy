package com.axhiao.aer.ch1;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin  = new Stack<>();

    public void push(int newNum) {
        stackData.push(newNum);
        if (stackMin.empty() || newNum <= stackMin.peek()) {
            stackMin.push(newNum);
        }
    }

    public int pop() {
        if (stackData.empty()) {
            throw new RuntimeException("Your stack is empty!");
        }

        int val = stackData.pop();
        if (val == stackMin.peek()) {
            stackMin.pop();
        }
        return val;
    }

    public int getMin() {
        if (stackMin.empty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();

        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        minStack.push(1);
        minStack.push(2);
        minStack.push(1);

        System.out.println(minStack.getMin());

        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());

        System.out.println("========= END ===========");
    }

}


class MinStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack2() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        this.stackData.push(newNum);
        if (this.stackMin.empty() || newNum <= this.stackMin.peek()) {
            this.stackMin.push(newNum);
        } else {
            this.stackMin.push(this.stackMin.peek());
        }
    }

    public int pop() {
        if (this.stackData.empty()) {
            throw new RuntimeException("Your stack is empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.empty()) {
            throw new RuntimeException("Your stack is empty!");
        }
        return this.stackMin.peek();
    }

}