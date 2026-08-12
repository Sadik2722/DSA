import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main{
    public static int[] nextGreaterElement(int[] nums1,int[] nums2){

        Map<Integer,Integer> gretaerEle=new HashMap<>();
        Stack<Integer> st=new Stack<>();

        for(int num:nums2){

            while(!st.isEmpty() && st.peek()<num){
                gretaerEle.put(st.pop(),num);
            }
            st.push(num);
        }

        int[] res=new int[nums1.length];
        for (int i=0;i<nums1.length;i++){
            res[i]=gretaerEle.getOrDefault(nums1[i],-1);
        }
        return res;
    }
    public static void main(String args[]){
        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};

        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
    }
}
