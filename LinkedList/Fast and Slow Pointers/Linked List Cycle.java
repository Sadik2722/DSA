public class Main{
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static boolean hasCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if (slow==fast)return true;
        }
        return false;
    }
    public static void main(String args[]){
        ListNode head=new ListNode(3,null);
        head.next=new ListNode(2,null);
        head.next.next=new ListNode(0,null);
        head.next.next.next=new ListNode(-4,head.next);

        System.out.print(hasCycle(head));
    }
}
