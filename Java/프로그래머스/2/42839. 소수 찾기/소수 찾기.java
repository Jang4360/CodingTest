import java.util.*;
class Solution {
    static boolean[] visited;
    static Set<Integer> set;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        String[] numbersArr = new String[numbers.length()];
        set = new HashSet<>();
        for (int i = 0; i<numbers.length(); i++) {
            numbersArr[i] = String.valueOf(numbers.charAt(i));
        }
        
        dfs(numbersArr, new ArrayList<>());
        
        return set.size();
    }
    
    public void dfs(String[] numbersArr, List<String> list) {
        if (list.size()>0) {
            int result = 0;
        
            for (String num : list) {
                result = result * 10 + Integer.parseInt(num);
            }
            if (isPrime(result)) set.add(result);
        }
        
            
        for (int i = 0; i<numbersArr.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            list.add(numbersArr[i]);
            dfs(numbersArr, list);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
    
    
    public boolean isPrime(int n) {
        if (n<2) return false;
        for (int i = 2; i*i <=n; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }
}