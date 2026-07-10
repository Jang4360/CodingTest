import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n+1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i<=n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] arr : edge) {
            int x = arr[0];
            int y = arr[1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {1,0});
        visited[1] = true;
        Map<Integer, List<Integer>> result = new HashMap<>();
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int cnt = cur[1];
            if (cnt>0){
                if (result.containsKey(cnt)) {
                    result.get(cnt).add(node);
                } else{
                    result.put(cnt, new ArrayList<>());
                    result.get(cnt).add(node);
                }
            }
           
            for (int val : map.get(node)) {
                if (visited[val]) continue;
                
                q.offer(new int[]{val, cnt+1});
                visited[val] = true;   
            }
        }
        int far = 0;
        for (int key : result.keySet()) {
            if (key > far) far = key;
        }
        
        return result.get(far).size();
    }
}