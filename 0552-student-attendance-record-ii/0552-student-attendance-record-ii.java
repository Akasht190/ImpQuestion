class Solution {
      private static final int MOD = 1000000000 + 7;
    public int checkRecord(int n) {
        long[][][] dp=new long[n+1][2][3];
        for(long[][] i:dp){
            for(long[] j:i){
                Arrays.fill(j,-1);
            }
        }
        return (int) solve(n,1,2,dp);
    }

    private long solve(int n,int absent,int late,long[][][]dp){
        if(n==0){
            return 1;

        }
        if(dp[n][absent][late]!=-1){
            return dp[n][absent][late];
        }
        long ans=0;
        if(absent>=1){
            ans+=(solve(n-1,absent-1,2,dp)%MOD);
        }
        if(late>=1){
            ans+=(solve(n-1,absent,late-1,dp)%MOD);
        }
        ans+=(solve(n-1,absent,2,dp)%MOD);
        ans%=MOD;
        return dp[n][absent][late]=ans;

    }
}