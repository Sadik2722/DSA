import java.util.*;
public class Main{
    static class ListNode{
        int val;;
        ListNode next;
        ListNode prev;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
            prev=null;
        }
    }
   public static ListNode insertAtPos(ListNode head, int p, int x){

        ListNode curr=head;

        for(int i=0;i<p;i++){
            curr=curr.next;
        }

        ListNode newNode=new ListNode(x, null);

        newNode.next=curr.next;
        newNode.prev=curr;

        if(curr.next !=null){
            curr.next.prev=newNode;
        }
        curr.next=newNode;

        return head;
   }
    public static void print(ListNode head){
        ListNode curr = head;

        // Move to the last node
        ListNode tail = null;

        System.out.print("Forward: ");

        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            tail = curr;
            curr = curr.next;
        }

        System.out.println("null");

        // Print backwards
        curr = tail;

        System.out.print("Backward: ");

        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.prev;
        }

        System.out.println("null");
    }
    public static void main(String args[]){

        ListNode l1 = new ListNode(5, null);

        l1.next = new ListNode(2, null);
        l1.next.prev = l1;

        l1.next.next = new ListNode(13, null);
        l1.next.next.prev = l1.next;

        l1.next.next.next = new ListNode(3, null);
        l1.next.next.next.prev = l1.next.next;

        l1.next.next.next.next = new ListNode(8, null);
        l1.next.next.next.next.prev = l1.next.next.next;

        int p = 2;
        int x = 6;

        insertAtPos(l1, p, x);

        print(l1);
    }
}
