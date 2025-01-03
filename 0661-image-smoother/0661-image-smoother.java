class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n=img.length;
        int m=img[0].length;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=smoother(img,i,j);
            }
        }
        return ans;
    }

    public int smoother(int[][] image,int x,int y){
        int n=image.length;
        int m=image[0].length;

        int sum=0;
        int count=0;

        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nx=x+i;
                int ny=y+j;

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

                sum+=image[nx][ny];
                count++;
            }
        }
        return sum/count;
    }
}