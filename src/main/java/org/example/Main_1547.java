package org.example;

import java.util.*;

public class Main_1547 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> cups = new ArrayList<>(Arrays.asList(1, 2, 3));

        int changeCount = scanner.nextInt();
        int temp;

        for (int i = 0; i < changeCount; i++) {
            int cup1 = scanner.nextInt();
            int cup2 = scanner.nextInt();
            temp = cups.indexOf(cup2);
            cups.set(cups.indexOf(cup1), cup2);
            cups.set(temp, cup1);
        }

        System.out.println(cups.get(0));
    }
}
