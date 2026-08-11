public class Main {

    // Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Previous node during inorder traversal
    static TreeNode prev = null;

    // Head of the Doubly Linked List
    static TreeNode head = null;

    // Convert Binary Tree to DLL
    public static TreeNode treeToDLL(TreeNode root) {

        if (root == null) {
            return null;
        }

        inorder(root);

        return head;
    }

    // Inorder traversal
    private static void inorder(TreeNode current) {

        if (current == null) {
            return;
        }

        // Step 1: Go left
        inorder(current.left);

        // Step 2: Process current node
        if (prev == null) {

            // First node in inorder
            head = current;

        } else {

            // Connect previous node with current node
            prev.right = current;
            current.left = prev;
        }

        // Move prev to current
        prev = current;

        // Step 3: Go right
        inorder(current.right);
    }

    // Print DLL from left to right
    public static void printDLL(TreeNode head) {

        TreeNode current = head;

        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.right;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create Binary Tree
        //
        //         4
        //        / \
        //       2   5
        //      / \
        //     1   3

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Convert Tree to DLL
        TreeNode dllHead = treeToDLL(root);

        // Print DLL
        printDLL(dllHead);
    }
}
