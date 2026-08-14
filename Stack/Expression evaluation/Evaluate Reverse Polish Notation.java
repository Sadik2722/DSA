import java.util.Stack;

public class Main {

    public static int evalRPN(String[] tokens){
        Stack<Integer> st=new Stack<>();
        int res=0;
        for(String num: tokens){
            if(!"+-*/".contains(num)){
                st.push(Integer.valueOf(num));
                continue;
            }
            int num2=st.pop();
            int num1=st.pop();

            switch (num){
                case"+":
                    res=num1+num2;
                    break;
                case"-":
                    res=num1-num2;
                    break;
                case "*":
                    res=num1*num2;
                    break;
                case "/":
                    res=num1/num2;
                    break;
            }
            st.push(res);
        }
        return st.pop();
    }
    public static void main(String args[]){
        String[] tokens = {"2","1","+","3","*"};
        
        System.out.print(evalRPN(tokens));
    }
}
