class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return count(dp,n);
    }

    public int count(int[]dp,int n){
        int i=1;
        int ans=Integer.MAX_VALUE;
        if(n==0){
            return 0;
        }

        if(dp[n]==-1){
            while(i*i<=n){
                ans=Math.min(ans,count(dp,(n-i*i)));
                i=i+1;
            }
            dp[n]=ans+1;
        }
        return dp[n];
    }
}