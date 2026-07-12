import java.util.*;
class Solution {
    static int answer;
    static String[] arr = {"A","E","I","O","U"};
    static int cnt;
    public int solution(String word) {
        cnt = 0;
        answer = 0;
        dfs(new ArrayList<String>(), word);
        return answer;
    }
    
    public void dfs(List<String> list, String word) {
        
        if (list.size()>0) {
            cnt++;
            String str = String.join("",list);
            if (str.equals(word)) {
                answer = cnt;
                return;
            }
        }        
        
        if (list.size()==5) return;
        
        for (int i = 0; i<arr.length; i++) {

            list.add(arr[i]);
            dfs(list, word);
            list.remove(list.size()-1);
            if (answer!=0) return;
        }
        
    }
}