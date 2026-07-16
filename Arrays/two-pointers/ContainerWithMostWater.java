public class Main {
    public static int maxArea(int[] height){
        int l=0,r=height.length-1;
        int max=0;
        while(l<r){
            int ht=Math.min(height[l],height[r]);
            int width=r-l;
            max=Math.max(max,width*ht);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
    public static void main (String args []){
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

}
