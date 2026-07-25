import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] tArr = term.split(" ");
            termMap.put(tArr[0], Integer.parseInt(tArr[1]));
        }
        int i = 1;
        for (String privacy : privacies) {
            String[] pArr = privacy.split(" ");
            String key = pArr[1];
            
            if (totalDays(today) >= totalDays(pArr[0])+28*termMap.get(key)) answer.add(i);
            i++;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int totalDays(String date) {
        String[] darr = date.split("\\.");
        
        int year = Integer.parseInt(darr[0]);
        int month = Integer.parseInt(darr[1]);
        int day = Integer.parseInt(darr[2]);
        return (28*12)*year + 28*month + day;
    }
}