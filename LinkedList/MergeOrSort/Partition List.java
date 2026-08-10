public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
   public static ListNode partition(ListNode head, int x){
        ListNode lessHaed=new ListNode(0,null);
        ListNode greaterHead=new ListNode(0,null);

        ListNode lessTail=lessHaed;
        ListNode greaterTail=greaterHead;

        ListNode curr=head;
        while (curr!=null){
            ListNode next=curr.next;
            curr.next=null;

            if(curr.val<x){
                lessTail.next=curr;
                lessTail=curr;
            }else{
                greaterTail.next=curr;
                greaterTail=curr;
            }
            curr=next;
        }
        lessTail.next=greaterHead.next;
        greaterTail.next=null;

        return lessHaed.next;
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
        head.next=new ListNode(4 ,null);
        head.next.next=new ListNode(3,null);
        head.next.next.next=new ListNode(2,null);
        head.next.next.next.next=new ListNode(5,null);
        head.next.next.next.next.next=new ListNode(2,null);
        int x=3;
        
        ListNode hd=partition(head,3);
        print(hd);
    }
}
