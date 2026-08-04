import java.util.HashMap;

public class Main{
    public static int longestKSubstr(String s, int k){
        HashMap<Character,Integer> hashMap=new HashMap<>();

        int left=0;
        int maxLen=-1;

        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);

            while(hashMap.size() >k){

                char leftchar=s.charAt(left);

                hashMap.put(leftchar,hashMap.get(leftchar)-1);

                if(hashMap.get(leftchar)==0){
                    hashMap.remove(leftchar);
                }
                left++;
            }
            if(hashMap.size()==k){
                maxLen=Math.max(maxLen,r-left+1);
            }
        }
        return maxLen;
    }
    public static void main(String args[]){
        String s="aabacbebebe";
        int k=3;
        System.out.println(longestKSubstr(s,k));
    }
}
