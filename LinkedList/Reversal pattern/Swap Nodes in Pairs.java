public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode swapPairs(ListNode head){
        ListNode dummy=new ListNode(0,null);
        dummy.next=head;
        ListNode prev=dummy;

        while(prev.next!=null && prev.next.next!=null){
            ListNode first=prev.next;
            ListNode second=first.next;

            first.next=second.next;
            second.next=first;
            prev.next=second;

            prev=first;
        }
        return dummy.next;
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

        ListNode hd=swapPairs(head);
        print(hd);

    }
}
