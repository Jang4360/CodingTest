import java.util.*;
class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(0, target, numbers, arr);
        return answer;
    }
    
    public void dfs(int start, int target, int[] numbers, ArrayList<Integer> arr) {
        if (arr.size() == numbers.length) {
            int sum = 0;
            for (int i = 0; i<numbers.length; i++) {
                if (arr.get(i) == 1) sum += numbers[i];
                else sum -= numbers[i];
            }
            if (sum == target) answer++;
            return;     
        }
        
        
        arr.add(1);
        dfs(start+1, target, numbers, arr);
        arr.remove(arr.size()-1);

        arr.add(0);
        dfs(start+1, target, numbers, arr);
        arr.remove(arr.size()-1);           
        
    }
    
}