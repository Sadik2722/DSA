public class Main{
    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data,ListNode next){
            this.data=data;
            this.next=next;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA == null || headB ==null)return null;

        ListNode pA=headA;
        ListNode pB=headB;

        while(pA!=pB){
            pA=(pA==null)?headB :pA.next;
            pB=(pB==null)?headA:pB.next;
        }
        return pA;
    }
    public static void main(String args[]){
        ListNode common = new ListNode(8, null);
        common.next = new ListNode(4, null);
        common.next.next = new ListNode(5, null);

        ListNode headA = new ListNode(4, null);
        headA.next = new ListNode(1, common);

        ListNode headB = new ListNode(5, null);
        headB.next = new ListNode(6, null);
        headB.next.next = new ListNode(1, common);

        ListNode ans=getIntersectionNode(headA,headB);

        if (ans != null)
            System.out.println(ans.data);
        else
            System.out.println("No Intersection");

    }
}
