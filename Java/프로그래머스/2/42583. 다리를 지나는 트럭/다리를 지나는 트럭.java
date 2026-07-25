import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        int idx = 0;
        int time = 0;
        Deque<int[]> q = new ArrayDeque<>();
        
        while (idx<truck_weights.length || !q.isEmpty()) {
            time++;
            if (!q.isEmpty() && q.peek()[1] == time) {
                int[] out = q.poll();
                sum -= out[0];
            }
            
            if (idx<truck_weights.length && truck_weights[idx]+sum <= weight) {
                sum += truck_weights[idx];
                q.offer(new int[] {truck_weights[idx], bridge_length+time});
                idx++;
            }
        }
        return time;
    }
}