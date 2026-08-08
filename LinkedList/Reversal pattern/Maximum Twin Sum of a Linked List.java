public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static int pairSum(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null,curr=slow;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        ListNode left=head;
        ListNode right=prev;

        int maxSum=0;
        while(right!=null){
            maxSum=Math.max(maxSum, left.val+right.val);
            left=left.next;
            right=right.next;
        }
        return maxSum;
    }
    public static void main(String args[]){
        ListNode head=new ListNode(1,null);
        head.next=new ListNode(4 ,null);
        head.next.next=new ListNode(2,null);
        head.next.next.next=new ListNode(1,null);

        System.out.print(pairSum(head));

    }
}
