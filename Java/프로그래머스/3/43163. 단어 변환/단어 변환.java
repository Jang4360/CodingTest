import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;
        int m = begin.length();
        boolean[] visited = new boolean[n];
        
        Deque<String[]> q = new ArrayDeque<>();
        q.offer(new String[]{begin,"0"});
        while (!q.isEmpty()) {
            String[] arr = q.poll();
            String cur = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            if (cur.equals(target)) return num;
            for (int i = 0; i<n; i++) {
                int cnt = 0;
                if (visited[i]) continue;
                
                for (int j = 0; j<m; j++) {
                    if (words[i].charAt(j) == cur.charAt(j)) {
                        cnt++;
                    }
                }
                if (cnt == m-1) {
                    visited[i] = true;
                    q.offer(new String[]{words[i], String.valueOf(num+1)});
                }
            }
        }
        return 0;
    }
}