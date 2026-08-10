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
   public static int[] nextLargerNodes(ListNode head){
        int n=0;
        ListNode curr=head;
        while(curr!=null){
            n++;
            curr=curr.next;
        }
        int ans[]=new int[n];
        Deque<int[]> stack=new ArrayDeque<>();

        int idx=0;
        curr=head;

        while(curr!=null){
            while(!stack.isEmpty() && stack.peek()[0]< curr.val){
                int[] top=stack.pop();
                ans[top[1]]= curr.val;
            }
            stack.push(new int[]{curr.val,idx});
            idx++;
            curr=curr.next;
        }
        return ans;
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
        l1.next=new ListNode(1,null);
        l1.next.next=new ListNode(5,null);

        int[] res=nextLargerNodes(l1);

        System.out.print(Arrays.toString(res));
    }
}
