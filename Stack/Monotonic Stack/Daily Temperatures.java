import java.util.Arrays;
import java.util.Stack;

public class Main{
    public static int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[temperatures.length];
        Arrays.fill(res,0);

        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {

                int idx=st.pop();
                int diff=i-idx;
                res[idx]=diff;
            }
            st.push(i);
        }
        return res;
    }
    public static void main(String args[]){
        int[] temp={73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }
}
