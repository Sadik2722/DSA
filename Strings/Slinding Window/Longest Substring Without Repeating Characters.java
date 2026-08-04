public class Main{
    public static int lengthOfLongestSubstring(String s){
        int j=0;
        int max=0;
        int [] attendence=new int[128];

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            while (attendence[c]>0){
                attendence[s.charAt(j)]--;
                j++;
            }
            attendence[c]++;
            max=Math.max(max,i-j+1);
        }
        return max;
    }
    public static void main(String args[]){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
