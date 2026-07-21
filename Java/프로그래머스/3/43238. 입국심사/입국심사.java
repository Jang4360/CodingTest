import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1;
        long right = (long) times[0]*n;
        while (left<=right) {
            long mid = (left+right)/2;
            long cnt = 0;
            int time = 0;
            for (int t : times) {
                cnt += mid/t;
                if (cnt >= n) {
                    break;
                }
            }
            if (cnt >= n) {
                answer = mid;
                right = mid-1; 
            } else left = mid+1;
        }
        return answer;
    }
}