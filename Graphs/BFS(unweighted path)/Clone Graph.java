import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node curr = new Node(node.val);
        map.put(node, curr);

        for (Node nei : node.neighbors) {
            curr.neighbors.add(cloneGraph(nei));
        }

        return curr;
    }
}

public class Main {

    // Helper to build a sample graph and return the reference to node with val = 1
    // Graph structure (classic LeetCode example):
    // 1 -- 2
    // |    |
    // 4 -- 3
    private static Node buildSampleGraph() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        return n1;
    }

    // BFS print of graph as adjacency list (sorted by val) for easy verification
    private static void printGraph(Node start) {
        if (start == null) {
            System.out.println("null");
            return;
        }

        Map<Integer, List<Integer>> adj = new TreeMap<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            List<Integer> neighborVals = new ArrayList<>();
            for (Node nei : curr.neighbors) {
                neighborVals.add(nei.val);
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    queue.add(nei);
                }
            }
            Collections.sort(neighborVals);
            adj.put(curr.val, neighborVals);
        }

        System.out.println(adj);
    }

    // Check that no node in the cloned graph is the same object reference as in the original
    private static boolean isDeepCopy(Node original, Node clone) {
        if (original == null || clone == null) return original == clone;

        Set<Node> visitedOriginal = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(original);
        visitedOriginal.add(original);

        Set<Node> originalNodes = new HashSet<>();
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            originalNodes.add(curr);
            for (Node nei : curr.neighbors) {
                if (!visitedOriginal.contains(nei)) {
                    visitedOriginal.add(nei);
                    queue.add(nei);
                }
            }
        }

        Set<Node> visitedClone = new HashSet<>();
        queue.add(clone);
        visitedClone.add(clone);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (originalNodes.contains(curr)) {
                // Found a shared reference -> not a deep copy
                return false;
            }
            for (Node nei : curr.neighbors) {
                if (!visitedClone.contains(nei)) {
                    visitedClone.add(nei);
                    queue.add(nei);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Node original = buildSampleGraph();

        System.out.print("Original graph adjacency list: ");
        printGraph(original);

        Solution solution = new Solution();
        Node cloned = solution.cloneGraph(original);

        System.out.print("Cloned graph adjacency list:   ");
        printGraph(cloned);

        System.out.println("Is the clone a true deep copy (no shared node references)? "
                + isDeepCopy(original, cloned));

        // Test with null input
        Solution solution2 = new Solution();
        Node nullClone = solution2.cloneGraph(null);
        System.out.println("Clone of null input: " + nullClone);
    }
}
