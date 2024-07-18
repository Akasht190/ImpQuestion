class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int max=Integer.MIN_VALUE;
        int lsum=0;
        int rsum=0;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        max=lsum;
        int rightIndex=n-1;
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[rightIndex];
            rightIndex--;
            max=Math.max(max,lsum+rsum);
        }
        return max;
    }
}