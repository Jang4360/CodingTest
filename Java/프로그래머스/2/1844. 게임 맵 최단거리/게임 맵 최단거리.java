import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[] dirx = {0, 1, -1, 0};
        int[] diry = {1, 0, 0, -1};
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0,1});
        visited[0][0] = true;
    
        while (!q.isEmpty()) {
            int[] cur= q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];
            if (cx == n-1 && cy == m-1) return cnt;
            for (int d = 0; d<4; d++) {
                int nx = cx + dirx[d];
                int ny = cy + diry[d];
                if (nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny] || maps[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, cnt+1});
            }
        }
        
        return -1;
    }
}