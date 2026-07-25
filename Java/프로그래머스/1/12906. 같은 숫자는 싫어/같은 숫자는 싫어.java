import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int bef = arr[0];
        list.add(bef);
        for (int i = 1; i<arr.length; i++) {
            if (arr[i] == bef) continue;
            else {
                bef = arr[i];
                list.add(bef);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}