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
   public static ListNode reverseDLL(ListNode head){
        if(head==null){
            return null;
        }
        ListNode curr=head;
        ListNode temp=null;

        while(curr!=null){

            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;

            curr=curr.prev;
        }

        if(temp!=null){
            head=temp.prev;
        }

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

        ListNode l1 = new ListNode(3, null);

        l1.next = new ListNode(4, null);
        l1.next.prev = l1;

        l1.next.next = new ListNode(5, null);
        l1.next.next.prev = l1.next;

        ListNode hd=reverseDLL(l1);

        print(hd);
    }
}
