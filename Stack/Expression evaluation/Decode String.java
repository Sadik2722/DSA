import java.util.Stack;

public class Main {
    public static String decodeString(String s){
        Stack<Character> st=new Stack<>();

        for(char c:s.toCharArray()){
            if(c!=']'){
                st.push(c);
            }else {
                StringBuilder inner=new StringBuilder();
                while (st.peek() != '['){
                    inner.insert(0,st.pop());
                }
                st.pop();

                StringBuilder numStr=new StringBuilder();
                while (!st.empty() && Character.isDigit(st.peek())){
                    numStr.insert(0,st.pop());
                }
                int k=Integer.parseInt(numStr.toString());

                String repeated=inner.toString().repeat(k);
                for(char rc:repeated.toCharArray())st.push(rc);
            }
        }
        StringBuilder res=new StringBuilder();
        while(!st.empty()){
            res.insert(0,st.pop());
        }
        return res.toString();
    }
    public static void main(String args[]){
        String s="3[a]2[bc]";

        System.out.print(decodeString(s));
    }
}
