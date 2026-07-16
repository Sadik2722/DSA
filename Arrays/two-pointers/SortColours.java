public class Main {
    public static  void SortColours(int [] nums){
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<high){
            if(nums[mid]==0){
                Swap(nums,low,mid);
                low++;
                mid++;
            } else if (nums[mid]==1) {
                mid++;
            }else{
                Swap(nums,mid,high);
                mid++;
                high--;
            }
        }
    }
    public static void Swap(int[] nums,int a,int b){
        if(a==b)return;
        nums[a]=nums[a]+nums[b];
        nums[b]=nums[a]-nums[b];
        nums[a]=nums[a]-nums[b];
    }
    public static void main(String args[]){
        int nums[]={2,0,2,1,1,0};
        SortColours(nums);
        System.out.print(Arrays.toString(nums));
    }
}
