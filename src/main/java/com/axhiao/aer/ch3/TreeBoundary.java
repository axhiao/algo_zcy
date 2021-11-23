package com.axhiao.aer.ch3;

public class TreeBoundary {

    public static void preOrderTraverse(Node h) {
        if (h == null)
            return;
        System.out.print(h.value + " ");
        preOrderTraverse(h.left);
        preOrderTraverse(h.right);
    }

    public static void treeBoundary(Node h) {
        if (h == null)
            return;

        System.out.print(h.value + " ");
        Node left = h.left;
        Node right = h.right;

        while (left != null || right != null) {
            if (left != null) {
                System.out.print(left.value + " ");
            }
            if (right != null) {
                System.out.print(right.value + " ");
            }

            if (left.left != null)
                left = left.left;
            if (left.right != null)
                left = left.right;


        }




    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        Node n15 = new Node(15);
        Node n16 = new Node(16);
        n1.left = n2; n1.right = n3;
        n2.right = n4;
        n3.left = n5; n3.right = n6;
        n4.left = n7; n4.right = n8;
        n5.left = n9; n5.right = n10;
        n8.right = n11;
        n9.left = n12;
        n11.left = n13; n11.right = n14;
        n12.left = n15; n12.right = n16;


        preOrderTraverse(n1);
    }
}
