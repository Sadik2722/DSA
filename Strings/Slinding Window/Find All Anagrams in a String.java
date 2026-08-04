import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<Integer> findAnagrams(String s,String p){
        List<Integer> res=new ArrayList<>();
        if(p.length() >s.length())return res;

        int[] pCount=new int[26];
        int[] window=new int[26];

        for(char c:p.toCharArray()){
            pCount[c-'a']++;
        }
        for(int i=0;i<p.length();i++){
            window[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(window,pCount)){
            res.add(0);
        }

        for(int i=p.length();i<s.length();i++){
            char right=s.charAt(i);
            char left=s.charAt(i-p.length());

            window[right-'a']++;
            window[left -'a']--;

            if(Arrays.equals(window,pCount)){
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
    public static void main(String args[]){
        String s="cbaebabacd";
        String p="abc";

        System.out.println(findAnagrams(s,p));

    }
}
