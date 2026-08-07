public class Main{
    static class ListNode{
        int val;
        ListNode next;
         ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    private static ListNode slow;
    public static ListNode middleNode(ListNode head){
        slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void printLL(ListNode head){
        ListNode curr=head;
        while(curr!=null){
            System.out.print(curr.val+"->");
            curr=curr.next;
        }System.out.print("null");
    }
    public static void main(String args[]){
        ListNode head=new ListNode(1,null);
        head.next=new ListNode(2,null);
        head.next.next=new ListNode(3,null);
        head.next.next.next=new ListNode(4,null);
        head.next.next.next.next=new ListNode(5,null);

        middleNode(head);
        printLL(slow);
    }
}
