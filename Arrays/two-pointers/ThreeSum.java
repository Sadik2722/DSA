public class Main {
    public static List<List<Integer>> ThreeSum(int [] nums){
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int j=i+1,k= nums.length-1;

            if(i>0 && nums[i]==nums[i-1])continue;

            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])j++;
                } else if (sum>0) {
                    k--;
                }else {
                    j++;
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        int [] nums={-1,0,1,2,-1,-4};
        System.out.print(ThreeSum(nums));
    }
}
