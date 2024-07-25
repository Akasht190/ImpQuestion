class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();

        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        return checkCommon(text1,text2,0,0,dp);
    }

    private int checkCommon(String A,String B,int i,int j,int[][]dp){
        if(i==A.length()||j==B.length()){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(dp[i][j]==-1){
            if(A.charAt(i)==B.charAt(j)){
                dp[i][j]=checkCommon(A,B,i+1,j+1,dp)+1;
            }
            else{
                dp[i][j]=Math.max(checkCommon(A,B,i+1,j,dp),checkCommon(A,B,i,j+1,dp));
            }
        }
        return dp[i][j];
    }
}