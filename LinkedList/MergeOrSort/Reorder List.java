public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static void reorderList(ListNode head){
        if(head==null || head.next==null)return;

        ListNode slow=head,fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf=reverse(slow.next);
        slow.next=null;

        ListNode p1=head,p2=secondHalf;
        while (p2!=null){
            ListNode next1=p1.next;
            ListNode next2=p2.next;

            p1.next=p2;
            p2.next=next1;

            p1=next1;
            p2=next2;
        }
    }
    public static ListNode reverse(ListNode head){
        ListNode prev=null,curr=head;
        while (curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
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
        head.next=new ListNode(2 ,null);
        head.next.next=new ListNode(3,null);
        head.next.next.next=new ListNode(4,null);
        head.next.next.next.next=new ListNode(5,null);
        reorderList(head);
        print(head);
    }
}
