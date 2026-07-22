public class Main {
    public static int[][] updateMatrix(int[][] mat){
        int rows= mat.length;
        int cols=mat[0].length;
        int[][] res=new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                res[i][j]=Integer.MAX_VALUE-1;
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0)res[i][j]=mat[i][j];
                else{
                    if(i>0)res[i][j]=Math.min(res[i][j],res[i-1][j]+1);
                    if(j>0)res[i][j]=Math.min(res[i][j],res[i][j-1]+1);
                }
            }
        }
        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=0;j--){
                if(mat[i][j]!=0){
                    if(i<rows-1)res[i][j]=Math.min(res[i][j],res[i+1][j]+1);
                    if(j<cols-1)res[i][j]=Math.min(res[i][j],res[i][j+1]+1);
                }
            }
        }
        return res;
    }
    public static void main (String args[]){
        int[][] mat={
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        int ans[][]=updateMatrix(mat);

        for(int i=0;i< mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}
