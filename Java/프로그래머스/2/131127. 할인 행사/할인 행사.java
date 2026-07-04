import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i<discount.length; i++) {
            if (discount.length-i<10) break;
            if (!map.keySet().contains(discount[i])) continue;
            Map<String,Integer> newMap = new HashMap<>(map);
            
            for (int j = i; j<i+10; j++) {
                if (newMap.keySet().contains(discount[j])) {
                    newMap.put(discount[j], newMap.get(discount[j])-1);
                }
            }
            
            boolean ok = true;
            
            for (int num : newMap.values()) {
                if (num != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok==true) answer++;
        }
        return answer;
    }
}