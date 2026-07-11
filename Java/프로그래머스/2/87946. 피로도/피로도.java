import java.util.*;
class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        dfs(dungeons, new ArrayList<>(), k);
        return answer;
    }
    
    public void dfs(int[][] dungeons, List<Integer> list, int k) {
        if (list.size() == dungeons.length) {
            int curK = k;
            int cnt = 0;
            for (int i : list) {
                if (dungeons[i][0] <= curK) {
                    curK-=dungeons[i][1];
                    cnt++;
                } else break;
            }
            if (answer<cnt) answer = cnt;
            return;
        }
        
        for (int i = 0; i<dungeons.length; i++) {
            if (visited[i]) continue;
            list.add(i);
            visited[i] = true;
            dfs(dungeons, list, k);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}