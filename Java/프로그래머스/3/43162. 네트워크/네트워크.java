import java.util.*;
class Solution {
    static boolean[] arr;
    public int solution(int n, int[][] computers) {
        int answer = 1;
        arr = new boolean[n];
        arr[0] = true;
        bfs(0, computers, n);
        for (int i = 1; i<n; i++) {
            if (!arr[i]) {
                bfs(i, computers, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int start,int[][] computers, int n) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        visited[start] = true;
        q.offer(start);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i<n; i++) {
                if (i == cur) continue;
                if (!visited[i] && computers[cur][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                    arr[i] = true;
                }
            }
        }
    }
}