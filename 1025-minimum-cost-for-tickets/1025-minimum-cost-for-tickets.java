class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length];
        int ans=helper(days,costs,0,dp);
        return ans; 
    }

    public int helper(int[] days,int costs[],int i,int[]dp){
        if(i>=days.length) return 0;
        if(dp[i]>0) return dp[i];

        int op1=costs[0]+helper(days,costs,i+1,dp);

        int k=i;
        for(;k<days.length;k++){
            if(days[k]>=days[i]+7){
                break;
            }
        }
        int op2=costs[1]+helper(days,costs,k,dp);
        for(;k<days.length;k++){
            if(days[k]>=days[i]+30){
                break;
            }
        }
        int op3=costs[2]+helper(days,costs,k,dp);
         dp[i]=Math.min(op1,Math.min(op2,op3));
         return dp[i];
    }
}