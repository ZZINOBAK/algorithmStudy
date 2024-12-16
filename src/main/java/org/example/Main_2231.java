package org.example;

import java.util.*;

public class Main_2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 1; i <= 1000000; i++) {
            int generatedNumber = i + (i/1000000) + ((i%1000000)/100000) + ((i%100000)/10000) + ((i%10000)/1000) + ((i%1000)/100) + ((i%100)/10) + i%10;
            numMap.put(i, generatedNumber);
        }
        int targetNum = scanner.nextInt();
        int smallestGenNum = 1000000;

        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() == targetNum) {
                if (entry.getValue() < smallestGenNum) {
                    smallestGenNum = entry.getKey();
                }
            }
        }
        if (smallestGenNum != 1000000) {
            System.out.println(smallestGenNum);
        } else {
            System.out.println(0);
        }
    }
}


