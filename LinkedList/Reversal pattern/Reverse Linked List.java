public class Main {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode reverseList(ListNode head){
        ListNode curr=head;
        ListNode prev=null;

        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }
    public static void print(ListNode head){
        ListNode curr=head;

        while(curr!=null){
            System.out.print(curr.val+"->");
            curr=curr.next;
        }
        System.out.print("null");
    }
    public static void main(String args[]){
        ListNode head=new ListNode(1,null);
        head.next=new ListNode(2,null);
        head.next.next=new ListNode(3, null);
        head.next.next.next=new ListNode(4,null);
        head.next.next.next.next=new ListNode(5,null);

        head=reverseList(head);
        print(head);
    }
}
