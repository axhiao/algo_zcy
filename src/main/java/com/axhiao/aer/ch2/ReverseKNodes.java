package com.axhiao.aer.ch2;

import java.util.Stack;

public class ReverseKNodes {

    public static Node reverseKnodes1(Node head, int k) {
        if (k < 2) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node newHead = null;
        Node np = null;
        Node curr = head;
        while (curr != null) {
            if (stack.size() == k) {
                // pop k elements
                Node h = null;
                Node p = null;
                while (!stack.empty()) {
                    if (h == null) {
                        h = stack.pop();
                        p = h;
                    } else {
                        p.next = stack.pop();
                        p = p.next;
                    }
                }
                if (newHead == null) {
                    newHead = h;
                } else {
                    np.next = h;
                }
                np = p;
            }
            stack.push(curr);
            curr = curr.next;
        }
        Node tmp = linkStack(stack);
        if (tmp != null) {
            np.next = tmp;
        }
        return newHead;
    }

    public static Node linkStack(Stack<Node> stack) {
        if (stack == null) {
            return null;
        }
        Node h = null;
        while(!stack.empty()) {
            if (h == null) {
                h = stack.pop();
            } else {
                Node p = stack.pop();
                p.next = h;
                h = p;
            }
        }
        return h;
    }

    public static Node reverseKnodes2(Node head, int k) {
        return null;
    }

    public static void main(String[] args) {
        Node h = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(7);
        h.next = n1; n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        n5.next = n6; n6.next = null;
        Node nh = reverseKnodes1(h, 2);
        Utils.printLinkedList(nh);
    }
}
