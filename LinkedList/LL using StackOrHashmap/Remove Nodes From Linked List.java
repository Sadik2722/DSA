import java.util.*;
public class Main{
    static class ListNode{
        int val;;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
   public static ListNode removeNodes(ListNode head){
        Deque<ListNode> stack=new ArrayDeque<>();
        ListNode curr=head;

        while(curr!=null){
            while(!stack.isEmpty() && stack.peek().val <curr.val){
                stack.pop();
            }
            stack.push(curr);
            curr=curr.next;
       }
        ListNode next=null;
        while(!stack.isEmpty()){
            ListNode node=stack.pop();
            node.next=next;
            next=node;
        }
        return next;
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

        ListNode l1=new ListNode(5,null);
        l1.next=new ListNode(2,null);
        l1.next.next=new ListNode(13,null);
        l1.next.next.next=new ListNode(3,null);
        l1.next.next.next.next=new ListNode(8,null);

        ListNode hd=removeNodes(l1);

        print(hd);
    }
}
