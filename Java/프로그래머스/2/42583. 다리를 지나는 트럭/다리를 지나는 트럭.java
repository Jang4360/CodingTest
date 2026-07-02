import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int idx = 0;
        int sum = 0;
        
        Deque<int[]> bridge = new ArrayDeque<>();
        while (!bridge.isEmpty() || idx<truck_weights.length) {
            time++;
            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                int[] out = bridge.poll();
                sum -= out[0];
            }
                
            if (idx<truck_weights.length && sum+truck_weights[idx] <= weight){
                sum += truck_weights[idx];
                bridge.offer(new int[] {truck_weights[idx], time + bridge_length});
                idx++;                
            }
        }
        return time;
    }
}