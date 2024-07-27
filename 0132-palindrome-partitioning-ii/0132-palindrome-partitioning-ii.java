class Solution {
    public int minCut(String s) {
        int len=s.length();
        int[]dp=new int[len];
        Arrays.fill(dp,-1);
        return pal(0,dp,s,len)-1;
    }

    public int pal(int i,int[] dp,String s,int len){
        if(i==len){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }
        int ans=Integer.MAX_VALUE;
        for(int j=i;j<len;j++){
            if(isPalindrome(i,j,s)){
                ans=Math.min(ans,pal(j+1,dp,s,len));
            }
        }
        ans+=1;
        return dp[i]=ans;
    }

    private boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}