import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dirx = {0, 1, 0, -1};
        int[] diry = {1, 0, -1, 0};
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0,1});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] val = q.poll();
            int cx = val[0];
            int cy = val[1];
            int cd = val[2];
            if (cx == n-1 && cy == m-1) return cd;
            
            for (int d = 0; d<4; d++) {
                int nx = cx + dirx[d];
                int ny = cy + diry[d];
                if (0>nx || nx>=n || 0>ny || ny>=m || visited[nx][ny] || maps[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny, cd+1});
            }
        }
        return -1;
    }
}