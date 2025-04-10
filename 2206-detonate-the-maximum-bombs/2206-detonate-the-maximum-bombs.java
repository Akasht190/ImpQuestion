class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        int ans=0;
        for(int i=0;i<n;i++){
          ans=Math.max(ans,dfs(i,new boolean[n],bombs));
        }
        return ans;
    }

    public int dfs(int ind,boolean[] vis,int[][] bombs){
        vis[ind]=true;
        int count=1;

        for(int i=0;i<bombs.length;i++){
            if(!vis[i] && isRange(bombs[ind],bombs[i])){
                count+=dfs(i,vis,bombs);
            }
        }
        return count;
    }

    public boolean isRange(int[] a,int []b){
        long dx=a[0]-b[0],dy=a[1]-b[1],r=a[2];
        return dx*dx+dy*dy<=r*r;
    }
}