import java.util.Stack;

public class Main {
   public static int calculate(String s){
       Stack<Integer> st=new Stack<>();
       int res=0;
       int num=0;
       int sign=1;

       for(char c: s.toCharArray()){
           if(Character.isDigit(c)){
               num=num*10+(c-'0');
           }else if(c=='+'){
               res+=sign*num;
               num=0;
               sign=1;
           }else if(c=='-'){
               res+=sign*num;
               num=0;
               sign=-1;
           }else if(c=='('){
               st.push(res);
               st.push(sign);
               res=0;
               sign=1;
           }else if(c==')'){
               res+=sign*num;
               num=0;
               res*=st.pop();
               res+=st.pop();
           }
       }
       return res+sign*num;

   }
    public static void main(String args[]){
        String s="(1+(4+5+2)-3)+(6+8)";

        System.out.print(calculate(s));
    }
}
