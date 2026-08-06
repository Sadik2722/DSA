public class Main{
    public static class Node{
        int data;
        Node Next;

        public Node(Node next, int data) {
            this.Next = next;
            this.data = data;
        }
    }
    public static boolean SearchKey(Node head, int Key){
        Node temp=head;

        while(temp!=null){
            if(temp.data==Key){
                return true;
            }
            temp=temp.Next;
        }
        return false;
    }
    public static void main(String args[]){
        Node head = new Node(null, 1);
        head.Next = new Node(null, 2);
        head.Next.Next = new Node(null, 3);
        head.Next.Next.Next = new Node(null, 4);
        head.Next.Next.Next.Next = new Node(null, 5);

        System.out.println(SearchKey(head, 5));
    }
}
