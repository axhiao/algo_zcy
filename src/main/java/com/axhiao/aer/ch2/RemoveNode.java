package com.axhiao.aer.ch2;

public class RemoveNode {

    public static Node removeMidNode(Node head) {
        if (head == null || head.next == null)
            return head;
        if (head.next.next == null)
            return head.next;

        Node prev = head;
        Node curr = head.next.next;
        while (curr.next != null && curr.next.next != null) {
            prev = prev.next;
            curr = curr.next.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static Node removeByRatio(Node head, int a, int b) {
        if (head == null || a < 1 || b < 1 || a > b)
            return head;

        Node curr = head;
        int n = 0;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        n = (int)Math.ceil((double)(a * n) / (double)b );
        if (n == 1) {
            return head.next;
        }
        curr = head;
        while (--n != 1) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static void output(Node h) {
        while (h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node h = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
//        h.next = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
        output(h);
//        h = removeMidNode(h);
        h = removeByRatio(h, 3, 5);
        output(h);

    }
}
