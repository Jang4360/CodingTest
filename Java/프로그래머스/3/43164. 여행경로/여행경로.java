import java.util.*;
class Solution {
    static List<String> answer;
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (a,b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            else return a[0].compareTo(b[0]);
        });
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        List<String> route = new ArrayList<>();
        route.add("ICN");
        dfs(tickets, "ICN", route);
        
        return answer.toArray(new String[0]);
       
    }
    public boolean dfs(String[][] tickets, String cur, List<String> route) {
        if (route.size() == tickets.length+1) {
            answer = new ArrayList<>(route);
            return true;
        }
        
        for (int i = 0; i<tickets.length; i++) {
            if (cur.equals(tickets[i][0])) {
                if (visited[i]) continue;
                
                visited[i] = true;
                route.add(tickets[i][1]);
                if (dfs(tickets, tickets[i][1], route)) return true;
                visited[i] = false;
                route.remove(route.size()-1);
            }
        }
        return false;
    }
}