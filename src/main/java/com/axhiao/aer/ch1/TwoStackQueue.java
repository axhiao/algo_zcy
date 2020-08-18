package com.axhiao.aer.ch1;

import java.util.Stack;

public class TwoStackQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void push(int n) {
        this.stackPush.push(n);
    }

    public int poll() {
        if (this.stackPush.empty() && this.stackPop.empty()) {
            throw new RuntimeException("Your queue is empty!");
        }
        if (this.stackPop.empty()) {
         while (!this.stackPush.empty()) {
             this.stackPop.push(this.stackPush.pop());
         }
        }

        return this.stackPop.pop();
    }
    public int peek() {
        if (this.stackPush.empty() && this.stackPop.empty()) {
            throw new RuntimeException("Your queue is empty!");
        }
        if (this.stackPop.empty()) {
            while (!this.stackPush.empty()) {
                this.stackPop.push(this.stackPush.pop());
            }
        }

        return this.stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue two = new TwoStackQueue();
        two.push(1);
        two.push(2);
        two.push(3);
        two.push(4);
        two.push(5);
        two.push(6);

        System.out.println(two.poll());
        System.out.println(two.poll());
        System.out.println(two.poll());
        System.out.println(two.poll());
        System.out.println(two.poll());
        System.out.println(two.poll());

    }
}
