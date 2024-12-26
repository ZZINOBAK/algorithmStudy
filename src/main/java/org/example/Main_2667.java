package org.example;

import java.util.*;

public class Main_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};  // 동서남북 x 이동
    static int[] dy = {0, 0, -1, 1};  // 동서남북 y 이동
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j) - '0';  // 문자에서 정수로 변환
            }
        }

        List<Integer> result = new ArrayList<>();

        // 모든 칸을 탐색하면서, 아직 방문하지 않은 집을 찾으면 DFS 실행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int houseCount = dfs(i, j);  // 새 단지 시작 시 DFS
                    result.add(houseCount);  // 단지 내 집 수 저장
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(result);

        System.out.println(result.size());  // 단지 개수
        for (int count : result) {
            System.out.println(count);  // 각 단지의 집 개수
        }
    }

    public static int dfs(int x, int y) {
        // 스택을 사용하여 깊이 우선 탐색
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;  // 단지에 속한 집의 수

        // 스택이 빌 때까지 탐색
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0];
            int cy = current[1];

            // 동서남북 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 유효한 범위 내에 있고, 아직 방문하지 않았고, 집이 있는 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                    count++;  // 단지에 집 개수 추가됨
                }
            }
        }
        return count;  // 단지의 집 개수
    }
}