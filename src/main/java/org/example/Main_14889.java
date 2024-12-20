package org.example;

import java.util.Scanner;

public class Main_14889 {
    static int N;
    static int[][] arr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        visit = new boolean[N];
        dfs(0, 0);

        System.out.println(min);
    }

    static void dfs(int depth, int start) { //재귀함수
        if (depth == N/2) {
            diff();
            return;
        }
        for (int i = start; i < N; i++) {
            visit[i] = true;
            dfs(depth+1, i+1);
            visit[i] = false;
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int x = Math.abs(start - link);

        if (x == 0) {
            min = x;
        } else {
            min = Math.min(min, x);
        }
    }
}
