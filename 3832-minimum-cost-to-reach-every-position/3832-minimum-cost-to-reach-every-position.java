class Solution {
    public int[] minCosts(int[] cost) {
        int n=cost.length;
        int[] temp=new int[n];

        Arrays.fill(temp,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            temp[i]=cost[i];

            if(i>0){
                temp[i]=Math.min(temp[i],temp[i-1]);
            }
        }
        return temp;

    }
}