import java.util.HashMap;
import java.util.LinkedHashSet;

public class Main {

    class Node {
        int key;
        int value;
        int freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private int capacity;
    private int minFreq;

    // key -> Node
    private HashMap<Integer, Node> keyMap;

    // frequency -> keys
    private HashMap<Integer, LinkedHashSet<Integer>> freqMap;

    public Main(int capacity) {

        this.capacity = capacity;
        this.minFreq = 0;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        // Key doesn't exist
        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);

        // Increase frequency
        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Capacity is 0
        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (keyMap.containsKey(key)) {

            Node node = keyMap.get(key);

            node.value = value;

            // Using this key increases frequency
            increaseFrequency(node);

            return;
        }

        // Cache is full
        if (keyMap.size() == capacity) {

            // Get least frequently used keys
            LinkedHashSet<Integer> keys = freqMap.get(minFreq);

            // First key = least recently used
            int lfuKey = keys.iterator().next();

            // Remove from frequency list
            keys.remove(lfuKey);

            // Remove from key map
            keyMap.remove(lfuKey);
        }

        // Create new node
        Node newNode = new Node(key, value);

        keyMap.put(key, newNode);

        // New node always has frequency 1
        freqMap
                .computeIfAbsent(1, k -> new LinkedHashSet<>())
                .add(key);

        // Reset minimum frequency
        minFreq = 1;
    }

    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        // Remove from old frequency group
        freqMap.get(oldFreq).remove(node.key);

        // If old frequency was minimum
        // and there are no more keys with this frequency
        if (oldFreq == minFreq &&
                freqMap.get(oldFreq).isEmpty()) {

            minFreq++;
        }

        // Increase frequency
        node.freq++;

        // Add to new frequency group
        freqMap
                .computeIfAbsent(node.freq, k -> new LinkedHashSet<>())
                .add(node.key);
    }

    public static void main(String[] args) {

        Main cache = new Main(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3);

        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 3

        cache.put(4, 4);

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
