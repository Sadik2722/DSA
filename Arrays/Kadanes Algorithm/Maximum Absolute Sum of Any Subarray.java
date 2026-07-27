public class Main {

    public static int maxAbsoluteSum(int [] nums) {
        int maxsum = 0;
        int currmax = 0;

        int minsum = 0;
        int currmin = 0;

        for (int num : nums){
            currmax=Math.max(currmax+num,num);
            maxsum=Math.max(maxsum,currmax);

            currmin=Math.min(currmin+num,num);
            minsum=Math.min(minsum,currmin);
        }
        return Math.max(maxsum,Math.abs(minsum));
    }
    public static void main(String args[]){
        int [] nums={2,-5,1,-4,3,-2};

        System.out.print(maxAbsoluteSum(nums));
    }
}
