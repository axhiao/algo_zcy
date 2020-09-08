package com.axhiao.aer.ch2;

import java.util.List;

public class Utils {

    public static void output(List<Integer> list) {
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    public static void printLinkedList(Node h) {
        while (h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
        System.out.println();
    }
}
