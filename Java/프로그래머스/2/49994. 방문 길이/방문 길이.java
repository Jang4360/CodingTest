import java.util.*;
class Solution {
    public int solution(String dirs) {
        int[] dirx = {0,1,-1,0};
        int[] diry = {1,0,0,-1};
        Map<String, Integer> dirMap = new HashMap<>();
		dirMap.put("U",0); 
        dirMap.put("D",3); 
        dirMap.put("L",2); 
        dirMap.put("R",1); 
        
        Set<String> visited = new HashSet<>();
        int cx = 0;
        int cy = 0;
        int cnt = 0;
        for (int i = 0; i<dirs.length(); i++) {
            String dir = String.valueOf(dirs.charAt(i));
            int d = dirMap.get(dir);
            int nx = dirx[d] + cx;
            int ny = diry[d] + cy;
            String compare = Arrays.toString(new int[]{cx, cy, nx, ny});
            if (nx<-5 || nx>5 || ny<-5 || ny > 5 ) continue;
            if (!visited.contains(compare)) cnt++;
 			visited.add(Arrays.toString(new int[]{cx, cy, nx, ny}));
            visited.add(Arrays.toString(new int[]{nx, ny, cx, cy}));
            cx = nx;
            cy = ny;
        }
        
        return cnt;
    }
}