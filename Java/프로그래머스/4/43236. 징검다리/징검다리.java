import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        while (left <= right) {
            int mid = (left+right)/2;
            int removed = 0;
            int bef = 0;
            for (int i = 0; i<rocks.length; i++) {
                if (rocks[i] - bef < mid) removed++;
                else bef = rocks[i];
            }
            
            if (distance - bef < mid) removed++;
            
            if (removed <= n) {
                left = mid +1;
                answer = mid;
            } else {
                right = mid -1;
            }
        }
        return answer;
    }
}