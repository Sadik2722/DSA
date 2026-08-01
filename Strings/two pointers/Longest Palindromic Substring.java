public class Main {
    public static boolean ispailndrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static String longestPalidrome(String s){
        int max=0,start=0,end=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(ispailndrome(s,i,j)==true){
                    if((j-i+1)>max){
                        max=j-i+1;
                        start=i;
                        end=j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
    public static void main(String args[]){
        String s="babad";
        System.out.println(longestPalidrome(s));
    }
}
