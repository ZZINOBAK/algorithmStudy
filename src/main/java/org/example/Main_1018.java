package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1018 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizeOfBoard = new int[2];
        int changeCount = 0;

        List<Integer> firstW = new ArrayList<>();
        List<Integer> firstB = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 2; i++) { // 세로 + 가로
            sizeOfBoard[i] = scanner.nextInt();
        }

        scanner.nextLine();
        for (int x = 0; x < sizeOfBoard[0]; x++) { //세로
            String insert = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder(insert);
            if (x % 2 == 0) {
                // 1 - 8 W 1 453627
                for (int j = 0; j < sizeOfBoard[1] - 7; j++) { //13 - 7 = 6, 23 - 7 = 16
                    changeCount = 0;
                    for (int i = j; i < j + 8; i++) {
                        if (j % 2 == 0) {
                            if (i % 2 == 0) {
                                if (stringBuilder.charAt(i) != 'W') {
                                    changeCount++;
                                }
                            } else {
                                if (stringBuilder.charAt(i) != 'B') {
                                    changeCount++;
                                }
                            }
                        } else {
                            if (i % 2 != 0) {
                                if (stringBuilder.charAt(i) != 'W') {
                                    changeCount++;
                                }
                            } else {
                                if (stringBuilder.charAt(i) != 'B') {
                                    changeCount++;
                                }
                            }
                        }
                    }
                    firstW.add(changeCount);
                }
                // 1 - 8 B 1 435261
                for (int j = 0; j < sizeOfBoard[1] - 7; j++) {
                    changeCount = 0;
                    for (int i = j; i < j + 8; i++) {
                        if (j % 2 == 0) {
                            if (i % 2 == 0) {
                                if (stringBuilder.charAt(i) != 'B') {
                                    changeCount++;
                                }
                            } else {
                                if (stringBuilder.charAt(i) != 'W') {
                                    changeCount++;
                                }
                            }
                        } else {
                            if (i % 2 != 0) {
                                if (stringBuilder.charAt(i) != 'B') {
                                    changeCount++;
                                }
                            } else {
                                if (stringBuilder.charAt(i) != 'W') {
                                    changeCount++;
                                }
                            }
                        }
                    }
                    firstB.add(changeCount);
                }
            } else {
                // 1 - 8 B 2 445362
                for (int j = 0; j < sizeOfBoard[1] - 7; j++) {
                    changeCount = 0;
                    for (int i = j; i < j + 8; i++) {
                        if (j % 2 == 0) {
                            if (i % 2 == 0) {
                                if (stringBuilder.charAt(i) != 'W') {
                                    changeCount++;
                                }
                            } else {
                                if (stringBuilder.charAt(i) != 'B') {
                                    changeCount++;
                                }
                            }
                        } else {
                            if (i % 2 != 0) {
                                if (stringBuilder.charAt(i) != 'W') {
                                    changeCount++;
                                }
                            } else {
                                if (stringBuilder.charAt(i) != 'B') {
                                    changeCount++;
                                }
                            }
                        }
                    }
                    firstB.add(changeCount);
                }
                // 1 - 8 W 2 443526
                for (int j = 0; j < sizeOfBoard[1] - 7; j++) {
                    changeCount = 0;
                    for (int i = j; i < j + 8; i++) {
                        if (j % 2 == 0) {
                            if (i % 2 == 0) {
                                if (stringBuilder.charAt(i) != 'B') {
                                    changeCount++;
                                }
                            } else {
                                if (stringBuilder.charAt(i) != 'W') {
                                    changeCount++;
                                }
                            }
                        } else {
                            if (i % 2 != 0) {
                                if (stringBuilder.charAt(i) != 'B') {
                                    changeCount++;
                                }
                            } else {
                                if (stringBuilder.charAt(i) != 'W') {
                                    changeCount++;
                                }
                            }
                        }
                    }
                    firstW.add(changeCount);
                }
            }
        }

        for (int y = 0; y < (sizeOfBoard[1] - 7) * (sizeOfBoard[0] - 7); y+=sizeOfBoard[1] - 7) { // 3 * 6 = 18
            for (int x = 0; x < sizeOfBoard[1] - 7; x++) { //13 - 7 = 6, 8 - 7 = 1
                int sumW = 0;
                int sumB = 0;
                int repeatCount = 0; // 반복 횟수 관리 변수
                for (int i = x + y; repeatCount < 8; i += sizeOfBoard[1] - 7) {
                    sumW += firstW.get(i);
                    sumB += firstB.get(i);
                    repeatCount++; // 반복 횟수 증가
                }
                result.add(sumW);
                result.add(sumB);
            }
        }
        Collections.sort(result);
        System.out.println(result.get(0));
    }
}
