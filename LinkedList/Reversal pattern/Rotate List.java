public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode rotateRight(ListNode head,int k){
        if(head==null || head.next==null|| k==0)return head;

        int len=1;
        ListNode tail=head;
        while (tail.next!=null){
            tail=tail.next;
            len++;
        }
        k=k%len;
        if(k==0)return head;

        ListNode slow=head,fast=head;
        for(int i=0;i<k;i++)
            fast=fast.next;

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;;
        }

        ListNode newHead=slow.next;
        slow.next=null;
        fast.next=head;

        return newHead;
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
        int k=2;
        ListNode hd=rotateRight(head,k);
        print(hd);

    }
}
