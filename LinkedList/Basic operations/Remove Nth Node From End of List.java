public class Main {

    public static class Node{
        int data;
        Node next;

        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    public static Node removeNthFromEnd(Node head, int n){
        Node dummy=new Node(0,null);
        dummy.next=head;

        Node slow=dummy;
        Node fast=dummy;

        for(int i=0;i<=n;i++){
            fast=fast.next;
        }

        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    public static void print(Node head){
        Node temp=head;

        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }
    public static void main(String args[]){
        Node head=new Node(1,null);
        head.next=new Node(2,null);
        head.next.next=new Node(3,null);
        head.next.next.next=new Node(4,null);

        int n=2;
        removeNthFromEnd(head,n);
        print(head);
    }
}
