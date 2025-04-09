class Solution {
    int[] prefSum;
    int totalWeight;
    Random random;

    public Solution(int[] w) {
        this.prefSum=new int[w.length];
        this.totalWeight=0;
        this.random=new Random();

        for(int i=0;i<w.length;i++){
            totalWeight+=w[i];
            prefSum[i]=totalWeight;
        }
    }
    
    public int pickIndex() {
        int target=random.nextInt(totalWeight)+1;
        for(int i=0;i<prefSum.length;i++){
            if(target<=prefSum[i]){
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */