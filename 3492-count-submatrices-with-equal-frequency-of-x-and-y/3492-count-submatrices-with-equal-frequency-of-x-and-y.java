class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] prefx=new int[n+1][m+1];
        int[][] prefy=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefx[i][j]=prefx[i-1][j]+prefx[i][j-1] - prefx[i-1][j-1];
                prefy[i][j]=prefy[i-1][j]+prefy[i][j-1] - prefy[i-1][j-1];
                if(grid[i-1][j-1]=='X'){
                    prefx[i][j]++;
                }
                else if(grid[i-1][j-1]=='Y'){
                    prefy[i][j]++;
                }
            }
        }

        int res=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int x=prefx[i][j];
                int y=prefy[i][j];
                if(x>0 && x==y){
                    res++;
                }
            }
        }
        return res;
    }
}