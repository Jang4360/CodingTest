import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : scoville) {
            pq.offer(num);
        }
        
        while (pq.peek()<K) {
            if (pq.size()<2) {
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            int res = first + second*2;
            answer++;
            pq.offer(res);
        }
        return answer;
    }
}