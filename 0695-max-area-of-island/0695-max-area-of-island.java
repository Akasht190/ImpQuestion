class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j] == 1) {
                    int[] ans = new int[1];
                    send(grid, i, j, ans);
                    res = Math.max(res, ans[0]);
                }
        return res;
    }
    
    void send(int[][] grid, int i, int j, int[] ans) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0; ans[0]++;
        send(grid,i+1,j,ans); send(grid,i,j+1,ans);
        send(grid,i-1,j,ans); send(grid,i,j-1,ans);
    }
}