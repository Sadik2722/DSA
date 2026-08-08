public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right){
        if(left==right)return head;

        ListNode dummy=new ListNode(0,null);
        dummy.next=head;
        ListNode connector=dummy;

        for(int i=1;i<left;i++)connector =connector.next;

        ListNode tail=connector.next;

        for(int i=0;i<right-left;i++){
            ListNode toMove=tail.next;
            tail.next=toMove.next;
            toMove.next=connector.next;
            connector.next=toMove;
        }
        return dummy;
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
        head.next.next=new ListNode(3,null);
        head.next.next.next=new ListNode(4,null);
        head.next.next.next.next=new ListNode(5,null);
        int left=2;
        int right=4;

        reverseBetween(head,left,right);
        print(head);

    }
}
