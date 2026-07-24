import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] dirx = {1,0,0,-1}; // S E N W
        int[] diry = {0,1,-1,0};
        Map<Character, Integer> dir = new HashMap<>();
        dir.put('E', 1);
        dir.put('N', 3);
        dir.put('S', 0);
        dir.put('W', 2);
        int sx = 0;
        int sy = 0;
        int R = park.length;
        int C = park[0].length();
        for (int i = 0; i<R; i++) {
            for (int j = 0; j<C; j++) {
                if (park[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }
        
        for (String route : routes){
            char d = route.charAt(0);
            int far = Integer.parseInt(String.valueOf(route.charAt(2)));
            boolean go = true;;
            int cx = sx;
            int cy = sy;
            for (int i = 1; i<=far; i++) {
                int nx = sx + dirx[dir.get(d)]*i;
                int ny = sy + diry[dir.get(d)]*i;
                if (nx<0 || nx>=R || ny<0 || ny>=C || park[nx].charAt(ny) == 'X'){
                    go = false;
                    break;
                };
                cx = nx;
                cy = ny;
            }
            if (!go) continue;
            sx = cx;
            sy = cy;
        }
        int[] answer = {sx,sy};
        return answer;
        
    }
}