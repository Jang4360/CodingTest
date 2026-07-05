import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] one = {1,2,3,4,5,1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        Map<String,Integer> map = new HashMap<>();
        map.put("one",0);
        map.put("two",0);
        map.put("three",0);
        
        for (int i = 0; i<answers.length; i++) {
            if (one[i%10] == answers[i]) map.put("one", map.get("one")+1);
            if (two[i%8] == answers[i]) map.put("two", map.get("two")+1);
            if (three[i%10] == answers[i]) map.put("three", map.get("three")+1);
        }
        int maxVal = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > maxVal) maxVal = map.get(key);
        }
        
        if (map.get("one") == maxVal) answer.add(1);
        if (map.get("two") == maxVal) answer.add(2);
        if (map.get("three") == maxVal) answer.add(3);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}