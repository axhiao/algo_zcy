package com.axhiao.aer.ch2;

public class ReversePartialList {

    public static Node reversePart(Node head, int from, int to) {
        if (from >= to || from < 1)
            return head;

        Node curr = head;
        Node fprev = null;
        Node tnext = null;

        int i = 1;
        while(curr != null) {
            if (i == from - 1) {
                fprev = curr;
            }
            if (i == to + 1) {
                tnext = curr;
            }
            i++;
            curr = curr.next;
        }
        if (to >= i) // to is bigger than len(list)
            return  head;

        Node rhead = head; // rhead refers to the first element of sub-list
        if (fprev != null) {
            rhead = fprev.next;
        }
        // reverse from rhead to tnext
        curr = rhead;
        Node prev = null;
        while(curr != tnext) {
            Node t = curr;
            curr = curr.next;
            t.next = prev;
            prev = t;
        }
        // link together
        rhead.next = tnext; // head -> .. -> fprev -> [prev -> .. -> rhead] -> tnext -> ...
        if (fprev == null)
            head = prev;
        else
            fprev.next = prev;
        // --!
        return head;
    }

    public static void main(String[] args) {
        Node h = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        h.next = n1; n1.next = n2; n2.next = n3; n3.next = n4; n4.next = null;
        Utils.printLinkedList(h);
        Node nh = reversePart(h, 1, 5);
        Utils.printLinkedList(nh);

    }
}
