public class Main {
    public static boolean checkInclusion(String s1,String s2){
        if(s1.length()>s2.length())return false;

        int[] count=new int[26];

        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }

        int matches=0;
        for(int c:count){
            if(c == 0)matches++;
        }
        if(matches==26)return true;

        for(int i=s1.length();i<s2.length();i++){
            int right=s2.charAt(i)-'a';
            int left=s2.charAt(i-s1.length())-'a';

            count[right]--;
            if(count[right]==0)matches++;
            else if(count[right]==-1)matches--;

            count[left]++;
            if(count[left]==0)matches++;
            else if(count[left]==1)matches--;

            if(matches==26)return true;
        }
        return false;
    }
    public static void main (String args[]){
        String s1="ab";
        String s2="eidbaooo";

        System.out.println(checkInclusion(s1,s2));

    }
}
