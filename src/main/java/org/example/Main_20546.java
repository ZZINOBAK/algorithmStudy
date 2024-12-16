package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_20546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer[]> map = new HashMap<>();
        map.put("hyun", new Integer[]{0, 0});
        map.put("min", new Integer[]{0, 0});

        int budget = scanner.nextInt();
        map.get("hyun")[0] = budget;
        map.get("min")[0] = budget;

        int machineDuck = 0;
        int newMachineDuck;

        int priceUp = 0;
        int priceDown = 0;

        for (int i = 0; i < 14; i++) {
            newMachineDuck = scanner.nextInt();

            // 주가 상승 하락 확인
            if (machineDuck > newMachineDuck && i > 0) { // 하락
                priceDown--;
                priceUp = 0;
            } else if (machineDuck < newMachineDuck && i > 0) { // 상승
                priceUp++;
                priceDown = 0;
            }
            machineDuck = newMachineDuck;

            // 준현
            map.get("hyun")[1] += map.get("hyun")[0]/machineDuck;
            map.get("hyun")[0] -= (map.get("hyun")[0]/machineDuck)*machineDuck;


            // 성민
            if (priceDown <= -3) { // 매수
                map.get("min")[1] += map.get("min")[0]/machineDuck;
                map.get("min")[0] -= (map.get("min")[0]/machineDuck)*machineDuck;
            } else if (priceUp >= 3) { //매도
                map.get("min")[0] += map.get("min")[1]*machineDuck;
                map.get("min")[1] = 0;
            }
        }

        int hyun = map.get("hyun")[0] + (map.get("hyun")[1]*machineDuck);
        int min = map.get("min")[0] + (map.get("min")[1]*machineDuck);

        if (hyun > min) {
            System.out.println("BNP");
        } else if (min > hyun){
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
