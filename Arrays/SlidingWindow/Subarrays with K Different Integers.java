public class Main {
    public static int AtMost(int nums[],int k){
        int freq[]=new int[nums.length+1];
        int left=0,count=0,distinct=0;

        for(int right=0;right< nums.length;right++){
            if(freq[nums[right]]==0){
                distinct++;
            }
            freq[nums[right]]++;

            while(distinct >k){
                freq[nums[left]]--;
                if(freq[nums[left]]==0){
                    distinct--;
                }
                left++;
            }count+=right-left+1;
        }
        return count;
    }
    public static int subarraysWithKDistinct(int nums[],int k){
        return AtMost(nums,k)-AtMost(nums,k-1);
    }
    public static void main (String args[]){
        int nums[]={1,2,1,2,3};
        int k=2;
        System.out.println(subarraysWithKDistinct(nums,k));
    }
}
