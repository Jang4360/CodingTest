import java.util.*;
class Solution {
    static StringBuilder sb;
    static Map<String,Integer> metric;
    public String solution(String[] survey, int[] choices) {
        sb = new StringBuilder();
        metric = new HashMap<>();
        metric.put("R",0);
        metric.put("T",0);
        metric.put("C",0);
        metric.put("F",0);        
        metric.put("J",0);
        metric.put("M",0);
        metric.put("A",0);
        metric.put("N",0);
        
        for (int i = 0; i<survey.length; i++) {
            String left = String.valueOf(survey[i].charAt(0));
            String right = String.valueOf(survey[i].charAt(1));
            int c = choices[i];
            if (c == 4) continue;
            else if (c == 1) metric.put(left, metric.get(left)+3);
            else if (c == 2) metric.put(left, metric.get(left)+2);
            else if (c == 3) metric.put(left, metric.get(left)+1);
            else if (c == 5) metric.put(right, metric.get(right)+1);
            else if (c == 6) metric.put(right, metric.get(right)+2);
            else if (c == 7) metric.put(right, metric.get(right)+3);
        }
        
        compare("R","T");
        compare("C","F");
        compare("J","M");
        compare("A","N");
        
        return sb.toString();
    }
    
    public void compare(String a, String b) {
        if (metric.get(a).equals(metric.get(b))) sb.append(a);
        else {
            if (metric.get(a)>metric.get(b)) sb.append(a);
            else sb.append(b);
        }
    }
}