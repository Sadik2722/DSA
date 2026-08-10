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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Deque<Integer> stack1=new ArrayDeque<>();
        Deque<Integer> stack2=new ArrayDeque<>();

        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode head=null;

        while(!stack1.isEmpty() || !stack2.isEmpty()||carry!=0){
            int val1=stack1.isEmpty()?0: stack1.pop();
            int val2= stack2.isEmpty()?0:stack2.poll();

            int sum=val1+val2+carry;
            carry=sum/10;
            int digit=sum%10;

            ListNode node=new ListNode(digit,null);
            node.next=head;
            head=node;
        }
        return head;
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

        ListNode l1=new ListNode(7,null);
        l1.next=new ListNode(2,null);
        l1.next.next=new ListNode(4,null);
        l1.next.next.next=new ListNode(3,null);

        ListNode l2=new ListNode(5,null);
        l2.next=new ListNode(6,null);
        l2.next.next=new ListNode(4,null);

        ListNode res=addTwoNumbers(l1,l2);

        print(res);
    }
}
