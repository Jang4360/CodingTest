import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i = 1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] node : edge) {
            graph.get(node[0]).add(node[1]);
            graph.get(node[1]).add(node[0]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{1,0});
        
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int cn = cur[0];
            int cd = cur[1];
            if (cd > distance[cn]) continue;
            
            for (int nn : graph.get(cn)) {
                int dist = 1 + cd;
                if (dist<distance[nn]) {
                    pq.offer(new int[] {nn, dist});
                    distance[nn] = dist;
                }
            }
        }
        int max = 0;
        for (int d=1; d<=n; d++){
            max = Math.max(max, distance[d]);
        }
        
        for (int d=1; d<=n; d++){
            if (max == distance[d]) answer++;
        }
        return answer;
    }
}