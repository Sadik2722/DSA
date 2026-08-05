import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<Integer> findSubstring(String s,String[] words){
        List<Integer> ans=new ArrayList<>();

        if(s==null || words == null || words.length ==0) return ans;

        int wordLen=words[0].length();
        int wordCount=words.length;
        int totalLen=wordLen*wordCount;

        if(s.length()<totalLen)return  ans;

        Map<String,Integer> traget=new HashMap<>();
        for(String word:words){
            traget.put(word,traget.getOrDefault(word,0)+1);
        }

        for(int i=0;i<wordLen;i++){
            int left=i;
            int count=0;

            Map<String,Integer> window=new HashMap<>();

            for(int right=i;right+wordLen <=s.length();right+=wordLen) {

                String word = s.substring(right,right+wordLen);

                if(traget.containsKey(word)){

                    window.put(word,window.getOrDefault(word,0)+1);
                    count++;

                    while (window.get(word) > traget.get(word)){
                        String leftWord=s.substring(left,left+wordLen);
                        window.put(leftWord,window.get(leftWord)-1);
                        left+=wordLen;
                        count--;
                    }
                    if(count==wordCount){
                        ans.add(left);

                        String leftWord=s.substring(left,left+wordLen);
                        window.put(leftWord,window.get(leftWord)-1);
                        left+=wordLen;
                        count--;
                    }
                }else{
                    window.clear();
                    count=0;
                    left=right+wordLen;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]){
        String s="barfoothefoobarman";
        String[] words={"foo","bar"};

        System.out.println(findSubstring(s,words));
    }
}
