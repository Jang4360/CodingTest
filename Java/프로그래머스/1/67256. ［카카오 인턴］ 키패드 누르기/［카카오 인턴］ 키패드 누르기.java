import java.util.*;
class Solution {
    int[][] phone = new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
    int[] dirx = {0,1,-1,0};
    int[] diry = {1,0,0,-1};
    int[] left = {3,0};
    int[] right = {3,2};
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] leftNum = new int[]{1,4,7};
        int[] rightNum = new int[]{3,6,9};
        
        
        // dfs로 왼손 오른손 비교 - 같으면 hand로 비교
        
        for (int num : numbers) {
            int[] cur = find(num);
            
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = cur;
            }
            else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = cur;
            }
            else {
                String res = dijkstra(cur[0],cur[1],hand);
                sb.append(res);
                if (res.equals("R")) right = cur;
                else left = cur;
            }
        }
        return sb.toString();
    }
    
    
    public String dijkstra(int x, int y, String hand) {
        int[][] distance = new int[4][3];

        for (int i = 0; i < 4; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        distance[x][y] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        pq.offer(new int[]{x, y, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int cx = cur[0];
            int cy = cur[1];
            int cd = cur[2];

            if (cd > distance[cx][cy]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dirx[d];
                int ny = cy + diry[d];

                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 3) continue;

                int dist = cd + 1;

                if (dist < distance[nx][ny]) {
                    distance[nx][ny] = dist;
                    pq.offer(new int[]{nx, ny, dist});
                }
            }
        }

        int rd = distance[right[0]][right[1]];
        int ld = distance[left[0]][left[1]];

        if (ld == rd) {
            if (hand.equals("right")) return "R";
            else return "L";
        } else {
            if (ld > rd) return "R";
            else return "L";
        }
    }   
    public int[] find (int num) {
        int x = 0;
        int y = 0;
        for (int i = 0; i<4; i++) {
            for (int j = 0; j<3; j++) {
                if (phone[i][j] == num) {
                    x = i;
                    y = j;
                }
            }
        }
        return new int[]{x,y};
    }
}
