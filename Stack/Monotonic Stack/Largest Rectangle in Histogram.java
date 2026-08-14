import java.util.Stack;

public class Main {
    public static int largestRectangleArea(int[] heights){
        int maxArea=0;
        int n= heights.length;
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<=n;i++){
            int currH=(i==n)?0:heights[i];

            while (!st.isEmpty() && heights[st.peek()] > currH){
                int Height=heights[st.pop()];
                int width=(st.isEmpty())?i:i-st.peek()-1;
                maxArea=Math.max(maxArea,Height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
    public static void main(String args[]){
       int[] height={2,1,5,6,2,3};

       System.out.print(largestRectangleArea(height));
    }
}
