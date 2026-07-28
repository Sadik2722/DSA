import java.util.*;

public class Main {

    public static int countCompleteComponents(int n, int[][] edges) {

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        // Traverse every connected component
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;

                int vertices = 0;
                int degreeSum = 0;

                while (!queue.isEmpty()) {

                    int node = queue.poll();
                    vertices++;

                    // Add degree of current node
                    degreeSum += adj.get(node).size();

                    // Visit all neighbours
                    for (int neighbour : adj.get(node)) {

                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            queue.offer(neighbour);
                        }
                    }
                }

                // Check if the component is complete
                if (degreeSum == vertices * (vertices - 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 6;

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {3, 4}
        };

        int result = countCompleteComponents(n, edges);

        System.out.println("Number of Complete Components = " + result);
    }
}
