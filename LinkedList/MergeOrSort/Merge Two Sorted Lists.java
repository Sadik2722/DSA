public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode mergeTwoLists(ListNode  list1, ListNode list2){
        ListNode dummy=new ListNode(0,null);
        ListNode curr=dummy;

        while (list1 != null && list2 != null){
            if(list1.val<= list2.val){
                curr.next=list1;
                list1=list1.next;
            }else{
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }
        curr.next=(list1!=null)?list1:list2;

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
        ListNode list1=new ListNode(1,null);
        list1.next=new ListNode(2 ,null);
        list1.next.next=new ListNode(4,null);

        ListNode list2=new ListNode(1,null);
        list2.next=new ListNode(3,null);
        list2.next.next=new ListNode(4,null);

        ListNode hd=mergeTwoLists(list1,list2);
        print(hd);

    }
}
