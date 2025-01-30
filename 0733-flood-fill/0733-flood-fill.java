class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]!=color){
            dfs(image,sr,sc,color,image[sr][sc]);
        }
        return image;
    }
    public void dfs(int[][] image,int row,int col,int color,int curr){
        if(row<0 || row>=image.length || col<0 || col>=image[0].length || image[row][col]!=curr){
            return;
        }

        image[row][col]=color;

        dfs(image,row+1,col,color,curr);
        dfs(image,row-1,col,color,curr);
        dfs(image,row,col-1,color,curr);
        dfs(image,row,col+1,color,curr);
    }
}