import java.util.Arrays;

public class Main {
    public static int[][] matrixBlockSum(int [][] mat,int k){
        int m=mat.length;
        int n=mat[0].length;

        int ans[][] =new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum=0;

                int rowStart=Math.max(0,i-k);
                int rowEnd=Math.min(m-1,i+k);

                int colStart=Math.max(0,j-k);
                int colEnd=Math.min(n-1,j+k);

                for(int r=rowStart;r<=rowEnd;r++){
                    for(int c=colStart;c<=colEnd;c++){
                        sum+=mat[r][c];
                    }
                }
                ans[i][j]=sum;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        int mat[][]={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int k=1;
        int ans[][]=matrixBlockSum(mat,k);

        for(int i=0;i< mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
