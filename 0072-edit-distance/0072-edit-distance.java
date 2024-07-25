class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int [][] dp=new int[n][m];

        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               dp[i][j]=-1;
           }
        }
        return check(word1,word2,0,0,dp);
    }

    public int check(String a,String b,int i,int j,int[][]dp){
        if(i==a.length() && j==b.length()){
            return 0;
        }
        if(i==a.length()){
            return b.length()-j;
        }
        if(j==b.length()){
            return a.length()-i;
        }

        if(dp[i][j]==-1){
            if(a.charAt(i)==b.charAt(j)){
                dp[i][j]=check(a,b,i+1,j+1,dp);
            }
            else{
                int x=check(a,b,i,j+1,dp)+1;
                int y=check(a,b,i+1,j+1,dp)+1;
                int z=check(a,b,i+1,j,dp)+1;
                dp[i][j]=Math.min(x,Math.min(y,z));
            }
        }
        return dp[i][j];
    }
}