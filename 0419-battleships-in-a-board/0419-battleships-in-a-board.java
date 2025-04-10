class Solution {
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int count=0;
        boolean[][] vis=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && board[i][j]=='X'){
                    dfs(i,j,board,vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i,int j,char[][] board,boolean[][] vis){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!='X' || vis[i][j]){
            return;
        }

        vis[i][j]=true;
        dfs(i+1,j,board,vis);
        dfs(i-1,j,board,vis);
        dfs(i,j+1,board,vis);
        dfs(i,j-1,board,vis);
    }
}