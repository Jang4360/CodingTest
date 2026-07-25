import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int cnt = 0;
        int len = want.length;
        for (int i = 0; i<len; i++) {
            cnt += number[i];
        }
        
        for (int i = 0; i<=discount.length-cnt; i++) {
            Map<String,Integer> store = new HashMap<>();
            for (int j = i; j<i+cnt; j++) {
                store.put(discount[j], store.getOrDefault(discount[j],0)+1);
            }
            
            boolean isAnswer = true;
            for (int w = 0; w<len; w++) {
                if (!store.containsKey(want[w]) || store.get(want[w]) != number[w]) {
                    isAnswer = false;
                    break;
                }
            }
            if (isAnswer) answer++;
        }
        
        return answer;
    }
}