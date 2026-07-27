public class Main {
    public static int maxProduct(int [] nums){
        int maxprod=0;
        int minprod=0;
        int res=0;

        for(int i=0;i< nums.length;i++){
            int curr=nums[i];

            if(curr<0){
                int temp=maxprod;
                maxprod=minprod;
                minprod=temp;
            }

            maxprod=Math.max(curr,curr*maxprod);
            minprod=Math.min(curr,curr*minprod);

            res=Math.max(res,maxprod);
        }
        return res;
    }
    public static void main(String args[]){
        int nums[]={2,3,-2,4};

        System.out.print(maxProduct(nums));
    }
}
