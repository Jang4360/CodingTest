import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                q.add(')');
            } else {
                if (q.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    q.poll();
                }
            }
        }
        if (!q.isEmpty()) answer = false;
        return answer;
    }
}