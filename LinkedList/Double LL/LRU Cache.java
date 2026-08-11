import java.util.HashMap;

public class Main {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public Main(int capacity) {
        this.capacity = capacity;

        // IMPORTANT: initialize HashMap
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        addToFront(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.val = value;

            remove(node);
            addToFront(node);

            return;
        }

        Node newNode = new Node(key, value);

        map.put(key, newNode);
        addToFront(newNode);

        if (map.size() > capacity) {

            Node lru = tail.prev;

            remove(lru);

            // IMPORTANT: remove using the key
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToFront(Node node) {

        Node first = head.next;

        node.next = first;
        node.prev = head;

        head.next = node;
        first.prev = node;
    }

    public static void main(String[] args) {

        Main cache = new Main(2);

        System.out.println(cache.putAndPrint(1, 1));
        System.out.println(cache.putAndPrint(2, 2));
        System.out.println(cache.get(1));
        System.out.println(cache.putAndPrint(3, 3));
        System.out.println(cache.get(2));
        System.out.println(cache.putAndPrint(4, 4));
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    // Helper method only for printing null like LeetCode
    public String putAndPrint(int key, int value) {
        put(key, value);
        return "null";
    }
}
