import java.util.*;
class Solution {
    Map<Integer, List<Integer>> graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> answer = new ArrayList<>();
        graph = new HashMap<>();
        for (int i = 1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        int[] distance = dijkstra(n, destination);
        
        for (int s : sources) {
            if (distance[s] == Integer.MAX_VALUE) answer.add(-1);
            else answer.add(distance[s]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int[] dijkstra(int n, int destination) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[destination] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.offer(new int[]{destination,0});
        
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int cn = cur[0];
            int cd = cur[1];
            if (cd > distance[cn]) continue;
            for (int nn : graph.get(cn)){
                int dist = cd + 1;
                if (dist < distance[nn]) {
                    distance[nn] = dist;
                    pq.offer(new int[] {nn, dist});
                }
            }
        }
        return distance;
    }
}