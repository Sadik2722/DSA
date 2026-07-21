public class Main {
    public static int findMaxConsecutiveOnes(int [] nums){
        int count=0,i=0;
        int max=0;
        while (i< nums.length){
            if(nums[i]!=1){
                count=0;
            }else {
                count++;
            }
            i++;
            max=Math.max(max,count);
        }
        return max;
    }
    public static void main(String args[]){
        int nums[]={1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
