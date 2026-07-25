import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int subarraySum(int nums[],int k){
        int ans=0;
        int sum=0;
        HashMap<Integer,Integer> Map=new HashMap<>();
        Map.put(0,1);

        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
            if(Map.containsKey(sum-k)){
                ans+=Map.get(sum-k);
            }
            Map.put(sum,Map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
    public static void main(String args[]){
        int nums[]={1,2,3};
        int k=3;
        System.out.println(subarraySum(nums,k));
    }
}
