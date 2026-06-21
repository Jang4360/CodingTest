import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 가장 낮은 스코빌 지수를 빠르게 꺼내기 위해 우선순위 큐를 사용한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : scoville) {
            pq.offer(num);
        }

        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            int res = first + second * 2;
            answer++;
            pq.offer(res);
        }
        return answer;
    }
}
