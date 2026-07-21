public class Main {
    public static int totalFruit(int [] fruits) {

        int freq[] = new int[1000];
        int left = 0, distrint = 0, max = 0;

        for (int right = 0; right < fruits.length; right++) {
            if (freq[fruits[right]]==0){
                distrint++;
            }
            freq[fruits[right]]++;
            if(distrint>2){
                freq[fruits[left]]--;
                if(freq[fruits[left]]==0){
                    distrint--;
                }
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
    public static void main(String args[]){
        int nums[]={0,1,2,2};
        System.out.println(totalFruit(nums));
    }
}
