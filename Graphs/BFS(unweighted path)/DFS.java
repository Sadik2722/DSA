import java.util.ArrayList;

public class Main {

    static class Edge {
        int src;
        int des;
        int wei;

        Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wei = w;
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {

        // Visit the current node
        System.out.print(curr + " ");
        vis[curr] = true;

        // Visit all unvisited neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.des]) {
                dfs(graph, e.des, vis);
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        // Initialize ArrayLists
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

        boolean[] vis = new boolean[V];

        dfs(graph, 0, vis);
    }
}
