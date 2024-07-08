import java.util.PriorityQueue;

class Solution {
    static boolean[] visited;
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public String[] solution(String[][] tickets) {
        int len = tickets.length;
        visited = new boolean[len];
        dfs(tickets, 0, "ICN", "ICN", len);
        String[] answer = pq.peek().split(",");
        return answer;
    }

    private void dfs(String[][] tickets, int cnt, String cur, String path, int len) {
        if (cnt == len) {
            pq.add(path);
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i] && cur.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets, cnt + 1, tickets[i][1], path + "," + tickets[i][1], len);
                visited[i] = false;
            }
        }
    }
}