class Solution {
    private int f(int ind,int curr_reward,int[] rewardValues,int[][] dp){
        int n=rewardValues.length;
        if(ind>=n){
            return curr_reward;
        }

        if(dp[ind][curr_reward]!=-1){
            return dp[ind][curr_reward];
        }

        int not_take=f(ind+1,curr_reward,rewardValues,dp);

       int take=0;
        if(rewardValues[ind]>curr_reward){
            take=f(ind+1,curr_reward+rewardValues[ind],rewardValues,dp);
        }

        return dp[ind][curr_reward]=Math.max(take,not_take);
    }

    public int maxTotalReward(int[] rewardValues) {
        int n=rewardValues.length;
        Arrays.sort(rewardValues);

        int[][] dp=new int[n][4001];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(0,0,rewardValues,dp);
    }
}