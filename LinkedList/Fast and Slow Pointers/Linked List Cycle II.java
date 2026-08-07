public class Main {
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode detecCyacle(ListNode head){
        if(head == null || head.next ==null)return null;

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if (slow==fast)break;
        }
        if(fast==null || fast.next==null)return null;

        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
    public static void main(String args[]){
        ListNode head=new ListNode(3,null);
        head.next=new ListNode(2,null);
        head.next.next=new ListNode(0,null);
        head.next.next.next=new ListNode(-4,head.next);

        ListNode start = detecCyacle(head);

        if (start == null) {
            System.out.println(-1);
        } else {
            int index = 0;
            ListNode temp = head;

            while (temp != start) {
                temp = temp.next;
                index++;
            }
            System.out.println(index);
        }
    }
}
