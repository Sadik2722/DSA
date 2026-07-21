public class Main {
    public static int longestOnes(int [] nums, int k){
        int left=0,maxlength=0,zeroCount=0;
        for(int right=0;right <nums.length;right++){
            if(nums[right]==0){
                zeroCount++;
            }
            if(zeroCount > k){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }

    public static void main(String args[]){
        int nums[]={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(nums,k));
    }
}
