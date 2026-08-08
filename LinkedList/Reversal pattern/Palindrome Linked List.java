public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static boolean isPalindrome(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev=null,curr=slow;
        while (curr!=null){
            ListNode Next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }

        ListNode left=head;
        ListNode right=prev;

        while(left!=null && right!=null){
            if (right.val!=left.val){
                return false;
            }
            right=right.next;
            left=left.next;
        }
        return true;
    }
    public static void main(String args[]){
        ListNode head=new ListNode(1,null);
        head.next=new ListNode(2,null);
        head.next.next=new ListNode(2,null);
        head.next.next.next=new ListNode(1,null);

        System.out.print(isPalindrome(head));
    }
}
