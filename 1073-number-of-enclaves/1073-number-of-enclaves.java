class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}


class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j]=true;
                    }
                }
            }
        }
        int[] dir={-1,0,+1,0};
        int[] dic={0,+1,0,-1};

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();

            for(int i=0;i<4;i++){
                int nRow=row+dir[i];
                int nCol=col+dic[i];

                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && vis[nRow][nCol]==false && grid[nRow][nCol]==1){
                    q.add(new Pair(nRow,nCol));
                    vis[nRow][nCol]=true;
                }
            }
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}