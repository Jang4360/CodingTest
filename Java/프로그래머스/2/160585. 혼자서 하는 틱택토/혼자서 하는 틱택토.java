import java.util.*;
class Solution {
    static int[] dirx = {0,1,1,1};
    static int[] diry = {1,1,0,-1};
    public int solution(String[] board) {
        int cntO = getCnt('O', board);
        int cntX = getCnt('X', board);
        boolean isOThree = false;
        boolean isXThree = false;
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                if (board[i].charAt(j) == 'O') {
                    if (isThree(board, 'O', i, j)) {
                        isOThree = true;
                    }
                }
                else if (board[i].charAt(j) == 'X') {
                    if (isThree(board, 'X', i, j)) {
                        isXThree = true;
                    }
                }
            }
        }
        if (!(cntO==cntX || cntO==cntX+1)) return 0;
        if (isOThree && isXThree) return 0;
        if (isOThree && cntO != cntX+1) return 0;
        if (isXThree && cntO != cntX) return 0;
        return 1;
    }
    
    public boolean isThree(String[] board, Character ch, int i, int j) {
        int cnt = 1;
        for (int d = 0; d<4; d++) {
            cnt = 1;
            int nx = i + dirx[d];
            int ny = j + diry[d];
            if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
            while (board[nx].charAt(ny) == ch) {
                cnt++;
                if (cnt == 3) return true;
                nx += dirx[d];
                ny += diry[d];
                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) break;
            }
        }
        return false;
    }
    
    public int getCnt(Character ch, String[] board) {
        int cnt = 0;
        for (String str : board) {
            for (int j = 0; j<3; j++) {
                if (str.charAt(j) == ch) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}