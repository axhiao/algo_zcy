package com.axhiao.aer.ch2;

public class ReverseLinkedlist {

    public static Node reverseSingleList(Node head) {
        Node prev = null;
        Node next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static Node reversDualList(Node head) {
        Node prev = null;
        Node next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // one-way linked list
        Node h1 = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        h1.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node r = reverseSingleList(h1);
        while (r != null) {
            System.out.print(r.data + " ");
            r = r.next;
        }
        System.out.println();
    }
}
