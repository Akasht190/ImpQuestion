class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax=new int[grid.length];
        int[] colMax=new int[grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                rowMax[i]=Math.max(rowMax[i],grid[i][j]);
                colMax[j]=Math.max(colMax[j],grid[i][j]);
            }
        }

        int res=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int increase=Math.min(rowMax[i],colMax[j])-grid[i][j];
                res+=increase;
            }
        }
        return res;
    }
}