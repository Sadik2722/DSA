public class Main {
    public static String minwindow(String s,String t){
        int [] mapS=new int[256];
        int [] mapT=new int[256];

        for(char ch:t.toCharArray())
            mapT[ch]++;

            int left=0;
            int right=0;
            int minLen=Integer.MAX_VALUE;
            int minstart=0;

            for(;right<s.length();right++){
                mapS[s.charAt(right)]++;

                while (conatains(mapS,mapT)){

                    if(right-left+1<minLen){
                        minLen=right -left+1;
                        minstart=left;
                    }
                    mapS[s.charAt(left++)]--;
                }
            }
            return minLen==Integer.MAX_VALUE?"":s.substring(minstart,minstart+minLen);

    }
    public static boolean conatains(int[] mapS,int[] mapT){
        for(int i=0;i<256;i++){
            if(mapT[i] > mapS[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        String s="ADOBECODEBANC";
        String t="ABC";

        System.out.println(minwindow(s,t));
    }
}
