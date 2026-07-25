public class Main{
    public static int pivotIndex(int[] nums){
        int leftsum=0;
        int rightsum=0;

        for(int i=0;i<nums.length;i++){
            rightsum+=nums[i];
        }
        for(int i=0;i< nums.length;i++){
            rightsum-=nums[i];

            if(leftsum==rightsum){
                return i;
            }
            leftsum+=nums[i];
        }
        return -1;
    }
    public static void main(String args[]){
        int nums[]={1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
