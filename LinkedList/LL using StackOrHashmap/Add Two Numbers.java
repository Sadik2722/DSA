public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(0,null);
        ListNode curr=dummy;
        int carry=0;

        while(l1!=null || l2 !=null || carry != 0){
            int val1=(l1!=null)? l1.val :0;
            int val2=(l2!=null)? l2.val:0;

            int sum=val1+val2+carry;
            carry=sum/10;
            int digit=sum%10;

            curr.next=new ListNode(digit,null);
            curr=curr.next;

            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
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

        ListNode l1=new ListNode(2,null);
        l1.next=new ListNode(4,null);
        l1.next.next=new ListNode(3,null);

        ListNode l2=new ListNode(5,null);
        l2.next=new ListNode(6,null);
        l2.next.next=new ListNode(4,null);

        ListNode res=addTwoNumbers(l1,l2);

        print(res);
    }
}
