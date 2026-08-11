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
   public static ListNode delPos(ListNode head, int x){
        if(head==null){
            return null;
        }

        if(x==1){
            head=head.next;

            if(head!=null){
                head.prev=null;
            }
            return head;
        }
        ListNode curr=head;


        for(int i=1;i<x;i++){
            curr=curr.next;
        }
        curr.prev.next=curr.next;

        if(curr.next!=null){
            curr.next.prev=curr.prev;
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

        ListNode l1 = new ListNode(1, null);

        l1.next = new ListNode(3, null);
        l1.next.prev = l1;

        l1.next.next = new ListNode(4, null);
        l1.next.next.prev = l1.next;

        int x = 3;

        ListNode hd=delPos(l1,x);

        print(hd);
    }
}
