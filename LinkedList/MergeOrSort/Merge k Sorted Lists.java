public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
   public static ListNode mergeKList(ListNode[] lists){
        if(lists.length==0)return null;
        ListNode res=lists[0];

        for(int i=1;i<lists.length;i++){
            res=merge(res,lists[i]);
        }
        return res;
   }
   public static ListNode merge(ListNode L1,ListNode L2){
        ListNode dummy=new ListNode(0,null);
        ListNode curr=dummy;
        while (L1!=null && L2!=null){
            if(L1.val <= L2.val){
                curr.next=L1;
                L1=L1.next;
            }else{
                curr.next=L2;
                L2=L2.next;
            }
            curr=curr.next;
        }
        curr.next=L1!=null ? L1:L2;
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

        ListNode l1=new ListNode(1,null);
        l1.next=new ListNode(4,null);
        l1.next.next=new ListNode(5,null);

        ListNode l2=new ListNode(1,null);
        l2.next=new ListNode(3,null);
        l2.next.next=new ListNode(4,null);

        ListNode l3=new ListNode(2,null);
        l3.next=new ListNode(6,null);

        ListNode list[]={l1,l2,l3};

        ListNode res=mergeKList(list);

        print(res);


    }
}
