class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        return check(s,0,n-1,dp);
    }

    public int check(String s,int i,int j,int[][] dp){
        if(i==j){
            return 1;
        }
        if(i>j){
            return 0;
        }

        if(dp[i][j]==-1){
            if(s.charAt(i)==s.charAt(j)){
                dp[i][j]=check(s,i+1,j-1,dp)+2;
            }
            else{
                int a=check(s,i+1,j,dp);
                int b=check(s,i,j-1,dp);
                dp[i][j]=Math.max(a,b);
            }
        }
        return dp[i][j];
    }
}