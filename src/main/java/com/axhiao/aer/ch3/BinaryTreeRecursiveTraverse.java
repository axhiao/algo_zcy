package com.axhiao.aer.ch3;

import java.util.Stack;

public class BinaryTreeRecursiveTraverse {


    public static void preOrderRecurr(Node head) {
        if (head == null)
            return;
        System.out.print(head.value + " ");
        preOrderRecurr(head.left);
        preOrderRecurr(head.right);
    }

    public static void inOrderRecurr(Node head) {
        if (head == null)
            return;
        inOrderRecurr(head.left);
        System.out.print(head.value + " ");
        inOrderRecurr(head.right);
    }

    public static void posOrderRecurr(Node head) {
        if (head == null)
            return;
        posOrderRecurr(head.left);
        posOrderRecurr(head.right);
        System.out.print(head.value + " ");
    }

    public static void preOrderNonRecurr(Node head) {
        if (head == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.empty()) {
            Node curr = stack.pop();
            System.out.print(curr.value + " ");
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
    }

    public static void inOrderNonRecurr(Node head) {
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while(!stack.empty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.value + " ");
                curr = curr.right;
            }
        }
    }

    public static void posOrderNonRecurr(Node head) {
        if (head == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node h = head; // point to item in the top of stack
        stack.push(h);
        Node c = null; // point to last visited item.
        while(!stack.empty()) {
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right) {
                stack.push(c.left);
            } else if (c.right != null && h != c.right) {
                stack.push(c.right);
            } else {
                System.out.print(stack.pop().value + " ");
                h = c;
            }
        }
    }

    public static Node buildTree() {
        /*
                     1
                  /    \
                 2      3
                /      / \
               4       5  6
                \
                 7
        * */
        Node h1 = new Node(1);
        Node h2 = new Node(2);
        Node h3 = new Node(3);
        Node h4 = new Node(4);
        Node h5 = new Node(5);
        Node h6 = new Node(6);
        Node h7 = new Node(7);
        h1.left = h2; h1.right = h3;
        h2.left = h4;
        h3.left = h5; h3.right = h6;
        h4.right = h7;
        return h1;
    }

    public static void main(String[] args) {
        Node tree = buildTree();
        System.out.println("pre-Order Traverse:");
        preOrderRecurr(tree);
        System.out.println();
        preOrderNonRecurr(tree);
        System.out.println("\nin-Order Traverse:");
        inOrderRecurr(tree);
        System.out.println();
        inOrderNonRecurr(tree);
        System.out.println("\npost-Order Traverse:");
        posOrderRecurr(tree);
        System.out.println();
        posOrderNonRecurr(tree);
    }
}
