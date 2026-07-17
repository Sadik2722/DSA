import java.util.*;
public class Main {
    public static int maximumSubarraySum(int nums[],int k){
        int windowSum=0,maxSum=0;

        HashMap<Integer,Integer> freq=new HashMap<>();

        for(int r=0;r<nums.length;r++){
            if(freq.containsKey(nums[r])){
                freq.put(nums[r],freq.get(nums[r])+1);
            }else{
                freq.put(nums[r],1);
            }
            windowSum+=nums[r];

            if(r>=k){
                int l=nums[r-k];
                windowSum-=l;
                if(freq.get(l)==1){
                    freq.remove(l);
                }else{
                    freq.put(l,freq.get(l)-1);
                }
            }
            if(r>=k-1 && freq.size()==k){
                maxSum=Math.max(maxSum,windowSum);
            }
        }
        return maxSum;
    }
    public static void main(String args[]){
        int nums[]={1,5,4,2,9,9,9};
        int k=3;
        System.out.println(maximumSubarraySum(nums,k));
    }
}
