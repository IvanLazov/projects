package com.clouway.collections.pagebean;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoNextElementsException {
        Integer[] listValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(listValues));

        PageBean<Integer> bean = new PageBean<Integer>(list, 5);

        Scanner input = new Scanner(System.in);
        int n;

        System.out.println("1: Next\n2: Previous\n3: Current page\n4: Has next elements\n" +
                "5: Has previous elements\n6: First page\n7: Last page\n0: Exit");

        System.out.println(bean.next() + "\n");

        while ((n = input.nextInt()) != 0) {
            if (n == 1) {
                try {
                    System.out.print(bean.next() + "\n");
                } catch (NoNextElementsException e) {
                    System.out.print("No next elements");
                }
            }

            if (n == 2) {
                try {
                    System.out.print(bean.previous() + "\n");
                } catch (NoPreviousElementsException e) {
                    System.out.print("No previous elements");
                }
            }

            if (n == 3) {
                System.out.print("Current page: " + bean.getCurrentPage());
            }

            if (n == 4) {
                System.out.print("Next elements: " + bean.hasNext());
            }

            if (n == 5) {
                System.out.print("Previous elements: " + bean.hasPrevious());
            }

            if (n == 6) {
                System.out.print("First Page: " + bean.firstPage());
            }

            if (n == 7) {
                System.out.print("Last Page: " + bean.lastPage());
            }
        }
    }
}
