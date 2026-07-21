public class Main {
    public static int numSubarrayProductLessThanK(int [] nums, int k){

        int left=0,product=1,count=0;

        if(k<=1)return 0;

        for(int right=0;right<nums.length;right++){
            product*=nums[right];

            while(product>=k){
                product/=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }

    public static void main(String args[]){
        int nums[]={10,5,2,6};
        int k=100;
        System.out.println(numSubarrayProductLessThanK(nums,k));
    }
}
