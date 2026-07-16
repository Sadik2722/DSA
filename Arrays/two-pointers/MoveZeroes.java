public class Main {

    public static  void MoveZeroes(int[] nums){
        int l=0;
        for (int r=0;r< nums.length;r++){
            if(nums[r]!=0) {
                int temp=nums[r];
                nums[r]=nums[l];
                nums[l]=temp;
                l++;
            }
        }

    }
  public static void main(String[] args) {
        int[] nums={0,1,0,3,12};

        MoveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
