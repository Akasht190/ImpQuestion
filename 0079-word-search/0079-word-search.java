class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        int index=0;
        boolean[][] visited=new boolean[n][m];
        boolean result=false;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    result=backtrack(board,word,visited,i,j,0);
                    if(result) return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board,String word,boolean[][] visited,int row,int col,int index){
        if(index==word.length()){
            return true;
        }

        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!=word.charAt(index) || visited[row][col]){
            return false;
        }
        visited[row][col]=true;

        if(backtrack(board,word,visited,row+1,col,index+1) ||
           backtrack(board,word,visited,row-1,col,index+1) ||
           backtrack(board,word,visited,row,col+1,index+1) ||
           backtrack(board,word,visited,row,col-1,index+1)){
            return true;
           }
           visited[row][col]=false;
           return false;
    }
}