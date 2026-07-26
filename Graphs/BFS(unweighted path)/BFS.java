import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Edge {
        int src;
        int des;
        int wei;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wei = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        // Initialize each ArrayList
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Create graph
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

        bfs(graph);
    }
}
