import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static int[] asteroidCollision(int[] asteroids){
        Stack<Integer> st=new Stack<>();

        for(int ast: asteroids){
            while(!st.isEmpty() && ast < 0 && st.peek() > 0 && st.peek() < -ast ){
                st.pop();;
            }
            if(!st.isEmpty() && ast <0 && st.peek() >0){
                if(st.peek() == -ast){
                    st.pop();
                }
            }else {
                st.push(ast);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
    public static void main(String args[]){
        int[] asteroids={5,10,-5};
        System.out.print(Arrays.toString(asteroidCollision(asteroids)));
    }
}
