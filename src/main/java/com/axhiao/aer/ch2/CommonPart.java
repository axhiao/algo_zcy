package com.axhiao.aer.ch2;

public class CommonPart {

    public static void outputCommonPart(Node link1, Node link2) {
        Node h1 = link1;
        Node h2 = link2;

        while(h1 != null && h2 != null) {
            if (h1.data < h2.data)
                h1 = h1.next;
            else if (h1.data > h2.data)
                h2 = h2.next;
            else {
                System.out.print(h1.data + " ");
                h1 = h1.next;
                h2 = h2.next;
            }
        }
    }

    public static void output(Node link) {
        if (link == null)
            return;
        System.out.print(link.data + " ");
        Node n = link.next;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node link1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(6);
        Node n5 = new Node(7);
        Node n6 = new Node(9);
        Node n7 = new Node(13);
        link1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        Node link2 = new Node(0);
        Node m2 = new Node(1);
        Node m3 = new Node(2);
        Node m4 = new Node(3);
        Node m5 = new Node(5);
        Node m6 = new Node(7);
        Node m7 = new Node(9);
        Node m8 = new Node(12);
        link2.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        m5.next = m6;
        m6.next = m7;
        m7.next = m8;

        output(link1);
        output(link2);

        outputCommonPart(link1, link2);
    }
}
