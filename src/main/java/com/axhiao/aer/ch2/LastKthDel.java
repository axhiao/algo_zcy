package com.axhiao.aer.ch2;

public class LastKthDel {

    public static Node delLastKthOneway(Node head, int kth) {
        if (head == null || kth < 1)
            return head;

        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            kth--;
        }
        if(kth == 0) {
            head = head.next;
        }
        if (kth <  0) {
            curr = head;
            while (++kth != 0) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }

        return head;
    }

    public static Node delLastKthDualway(Node head, int kth) {
        if (head == null || kth < 1)
            return head;

        Node curr = head;
        while(curr != null) {
            kth--;
            curr = curr.next;
        }
        if (kth == 0) {
            head.next.prev = null;
            head = head.next;
        }
        if (kth < 0) {
            curr = head;
            while (kth != 0) {
                curr = curr.next;
                kth++;
            }
            curr.prev.next = curr.next;
            if (curr.next != null)
                curr.next.prev = curr.prev;
        }
        return head;
    }

    public static void output(Node h) {
        while (h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
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
        Node h = delLastKthOneway(h1, 1);
        output(h);
        System.out.println();
        // dual-way linked list
        Node h2 = new Node(1);
        Node m1 = new Node(2);
        Node m2 = new Node(3);
        Node m3 = new Node(4);
        Node m4 = new Node(5);
        h2.next = m1;
        m1.prev = h2;
        m1.next = m2;
        m2.prev = m1;
        m2.next = m3;
        m3.prev = m2;
        m3.next = m4;
        m4.prev = m3;
        Node hd = delLastKthDualway(h2, 4);
        output(hd);
    }
}
