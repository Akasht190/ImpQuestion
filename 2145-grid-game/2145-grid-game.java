class Solution {
    public long gridGame(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        long minResult=Long.MAX_VALUE;
        long row1Sum=0;

        for(int i=0;i<m;i++){
            row1Sum+=grid[0][i];
        }

        long row2Sum=0;

        for(int i=0;i<m;i++){
            row1Sum-=grid[0][i];
            minResult=Math.min(minResult,Math.max(row1Sum,row2Sum));
            row2Sum+=grid[1][i];
        }
        return minResult;
    }
}