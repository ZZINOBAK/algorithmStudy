package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        List<Integer> outputList = new ArrayList<>();
        int num;
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            num = scanner.nextInt();
            inputList.add(num);
            sum += num;
        }

        outer:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int result = sum - inputList.get(i) - inputList.get(j);
                if (result == 100) {
                    for (int x = 0; x < 9; x++) {
                        if (x != i && x != j) {
                            outputList.add(inputList.get(x));
                        }
                    }
                    break outer;
                }
            }
        }

        Collections.sort(outputList);

        for (Integer height : outputList) {
            System.out.println(height);
        }
    }
}