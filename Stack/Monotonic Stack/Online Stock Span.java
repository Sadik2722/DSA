import java.util.Stack;

public class Main{
    static class StockSpanner{
        Stack<int[]> st=new Stack<>();
        public int next(int price){

            int span=1;

            while(!st.isEmpty() && st.peek()[0] < price){
                span+=st.pop()[1];
            }
            st.push(new int[]{price,span});
            return span;
        }
    }
    public static void main(String args[]){
        StockSpanner obj=new StockSpanner();

        int[] prices={100,80,60,70,60,75,85};

        for(int price:prices){
            int span= obj.next(price);
            System.out.println("Price = " + price + ", Span = " + span);
        }

    }
}
