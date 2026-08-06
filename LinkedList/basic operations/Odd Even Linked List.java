public class Main {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null)return head;

        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=even;

        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;

            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
    public static void print(ListNode head){
        ListNode curr=head;
        while (curr!=null){
            System.out.print(curr.val+"->");
            curr=curr.next;
        }
        System.out.print("null");
    }
    public static void main(String args[]){
        ListNode head=new ListNode(1,null);
        head.next=new ListNode(2,null);
        head.next.next=new ListNode(3,null);
        head.next.next.next=new ListNode(4,null);
        head.next.next.next.next=new ListNode(5,null);

        oddEvenList(head);
        print(head);

    }
}
