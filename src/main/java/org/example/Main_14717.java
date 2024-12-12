package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_14717 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> cards = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int[] chosenCards = new int[2];

        for (int i = 0; i < chosenCards.length; i++) {
            chosenCards[i] = scanner.nextInt();
            cards.remove(Integer.valueOf(chosenCards[i]));
        }

        //영학이 패 족보 계산
        int yunghak;
        if (chosenCards[0] == chosenCards[1]) {
            yunghak = 10 + chosenCards[0];
        } else {
            yunghak = ((chosenCards[0] + chosenCards[1]) % 10) + 1;
        }

        //영학 뺀 패 족보 계산
        List<Integer> other = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).equals(cards.get(j))) {
                    other.add(10 + cards.get(i));
                } else {
                    other.add(((cards.get(i) + cards.get(j)) % 10) + 1);
                }
            }
        }

        //이길 확률 계산
        long winningCases = other.stream().filter(hand -> yunghak > hand).count();

        Float winProbability = (winningCases / ((other.size()) / 100.0f)) / 100;
        System.out.printf("%.3f\n", winProbability);

    }
}
