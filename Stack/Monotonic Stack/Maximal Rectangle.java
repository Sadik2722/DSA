import java.util.Stack;

public class Main {
    public static int maximalRectangle(char[][] matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[] height=new int[cols];
        int maxArea=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                height[j]=matrix[i][j]=='0'?0:height[j]+1;
            }
            maxArea=Math.max(maxArea,largestRectangleArea(height));
        }
        return maxArea;
    }
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
        char[][] matrix= new char[][]{{'1','0','1','0','0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

       System.out.print(maximalRectangle(matrix));
    }
}
