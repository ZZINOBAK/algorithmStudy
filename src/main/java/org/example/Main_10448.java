package org.example;

import java.util.*;

public class Main_10448 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tNum = new ArrayList<>();
        List<Integer> eurekaNum = new ArrayList<>();

        for (int i = 1; i < 45; i++) {
            tNum.add((i * (i + 1)) / 2);
        }

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int K = scanner.nextInt();
            eurekaNum.add(K);
        }

        for (int i = 0; i < 44; i++) {
            for (int j = 0; j < 44; j++) {
                for (int h = 0; h < 44; h++) {
                    int sum = tNum.get(i) + tNum.get(j) + tNum.get(h);
                    if (eurekaNum.contains(sum)) {
                        int idx = eurekaNum.indexOf(sum);
                        eurekaNum.set(idx, 1);
                    }
                }
            }
        }

        for (int i = 0; i < eurekaNum.size(); i++) {
            if (eurekaNum.get(i) != 1) {
                eurekaNum.set(i, 0);
            }
        }

        for (Integer y : eurekaNum) {
            System.out.println(y);
        }
    }
}
