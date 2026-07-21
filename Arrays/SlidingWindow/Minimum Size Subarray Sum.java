
public class Main {
    public static int minSubArrayLen(int [] nums,int target) {

        int left=0;
        int currentSum=0;
        int min=Integer.MAX_VALUE;
        for(int right=0;right< nums.length;right++){
            currentSum+=nums[right];

            while(currentSum>=target){
                min=Math.min(min,right-left+1);
                currentSum-=nums[left];
                left++;
            }
        }
        return currentSum==Integer.MAX_VALUE?0:min;

    }
    public static void main(String args[]){
        int nums[]={2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubArrayLen(nums,target));
    }
}
