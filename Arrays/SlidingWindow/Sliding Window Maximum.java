import java.util.*;
public class Main {

    public static int[] maxSlidingWindow(int[] nums,int k){
        int n=nums.length;
        Deque<Integer> deque=new ArrayDeque<>();
        int[] res=new int[n-k+1];

        for(int i=0;i<n;i++){

            if(!deque.isEmpty() && deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);

            if(i>=k-1){
                res[i-k+1]=nums[deque.peekFirst()];
            }
        }
        return res;
    }
    public static void main(String args[]){
        int nums[] ={1,3,-1,-3,5,3,6,7};
        int k=3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
}
