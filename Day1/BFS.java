import java.util.*;
public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
            Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(0, 2)),
                new ArrayList<>(Arrays.asList(0, 1, 3, 4)),
                new ArrayList<>(Arrays.asList(2)),
                new ArrayList<>(Arrays.asList(2))
            )
        );
        System.out.println(bfs(adj)); // prints traversal
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        int start = 0;
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        return order;
    }
}