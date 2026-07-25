import java.util.HashMap;

public class Main {
    public static boolean checkSubarraySum(int [] nums,int k){

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int prefixSum=0;

        for(int r=0;r< nums.length;r++){
            prefixSum+=nums[r];
            int remainder=prefixSum % k;

            if(map.containsKey(remainder)){
                if(r-map.get(remainder)>=2){
                    return true;
                }
            }else{
                map.put(remainder,r);
            }
        }
        return false;
    }
    public static void main(String args[]){
        int [] nums={23,2,6,4,7};
        int k=6;
        System.out.println(checkSubarraySum(nums,k));
    }
}
