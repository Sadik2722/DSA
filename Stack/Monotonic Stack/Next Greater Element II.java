import java.util.Arrays;
import java.util.Stack;

public class Main{
    public static int[] nextGreaterElements(int[] nums){
        Stack<Integer> st=new Stack<>();

        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        int n= nums.length;

        for(int i=n*2-1;i>=0;i--){
            int num=i%n;

            while (!st.isEmpty() && st.peek() <= num){
                st.pop();
            }
            if(i<n && !st.isEmpty()){
                res[i]=st.peek();
            }
            st.push(num);
        }
        return res;
    }
    public static void main(String args[]){
        int[] nums1={1,2,1};

        System.out.println(Arrays.toString(nextGreaterElements(nums1)));
    }
}
