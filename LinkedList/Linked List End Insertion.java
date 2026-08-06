public class Main {
    public static class Node{
        int data;
        Node next;

        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    public static Node insertAtEnd(Node head,int x){
         Node newNode=new Node(x,null);

         if (head == null)return newNode;

         Node temp=head;

         while (temp.next!=null){
             temp=temp.next;
         }
         temp.next=newNode;
         return head;
    }
    public static void Print(Node head){
        Node temp=head;

        while (temp!=null){
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

        insertAtEnd(head,5);
        Print(head);
    }
}
