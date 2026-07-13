import java.util.*;
class Solution {
    static int answer;
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 1; i<=n; i++) {
            map.put(i,new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        
        for (int i = 1; i<=n; i++) {
            for (int j : map.get(i)) {
                int a = bfs(map, i, j, n);
                int b = bfs(map, j, i, n);
                int ans = Math.abs(a-b);
                answer = Math.min(ans, answer);
            }
        }
        return answer;
    }
    
    public int bfs(Map<Integer,List<Integer>> map, int in, int out, int n) {
        boolean[] visited = new boolean[n+1];
        Deque<Integer> q = new ArrayDeque<>();
        visited[in] = true;
        q.offer(in);
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : map.get(cur)) {
                if (visited[next] || next == out) continue;
                visited[next] = true;
                q.offer(next);
                cnt++;
            }
        }
        return cnt;
    }
}