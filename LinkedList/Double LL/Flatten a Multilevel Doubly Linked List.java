public class Main {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        flattenAndGetTail(head);

        return head;
    }

    private static Node flattenAndGetTail(Node head) {

        Node current = head;
        Node last = null;

        while (current != null) {

            Node next = current.next;

            // Current node has a child
            if (current.child != null) {

                Node child = current.child;

                // Flatten child list
                Node childTail = flattenAndGetTail(child);

                // Connect current -> child
                current.next = child;
                child.prev = current;

                // Connect childTail -> original next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // Remove child pointer
                current.child = null;

                last = childTail;

            } else {
                last = current;
            }

            current = next;
        }

        return last;
    }

    // Print the flattened list
    public static void printList(Node head) {

        Node current = head;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // --------------------------------
        // Create main list
        // 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
        // --------------------------------

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;

        n4.next = n5;
        n5.prev = n4;

        n5.next = n6;
        n6.prev = n5;


        // --------------------------------
        // Create child list
        // 7 <-> 8 <-> 9 <-> 10
        // --------------------------------

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n7.next = n8;
        n8.prev = n7;

        n8.next = n9;
        n9.prev = n8;

        n9.next = n10;
        n10.prev = n9;


        // --------------------------------
        // Create second child list
        // 11 <-> 12
        // --------------------------------

        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n11.next = n12;
        n12.prev = n11;


        // --------------------------------
        // Connect child lists
        // --------------------------------

        // Node 3 has child 7
        n3.child = n7;

        // Node 8 has child 11
        n8.child = n11;


        // --------------------------------
        // Flatten
        // --------------------------------

        Node result = flatten(n1);


        // --------------------------------
        // Print result
        // --------------------------------

        printList(result);
    }
}
