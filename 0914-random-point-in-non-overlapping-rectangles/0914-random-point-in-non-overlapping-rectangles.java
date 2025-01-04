class Solution {
    int[][] rects;
    Random r=new Random();
    int total=0;
    List<Integer> sum=new ArrayList<>();
    public Solution(int[][] rects) {
        this.rects=rects;
        for(int[] rect:rects){
            total+=(rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
            sum.add(total);
        }
    }
    
    public int[] pick() {
        int target=r.nextInt(total);
        int lo=0,hi=rects.length-1;

        while(lo<hi){
            int  mid=lo+(hi-lo)/2;
            if(target>=sum.get(mid)){
               lo=mid+1;
            }
            else{
                hi=mid;
            }
        }

        int[] ans=rects[lo];
        int x1=ans[0];
        int y1=ans[1];
        int x2=ans[2];
        int y2=ans[3];
        int x=r.nextInt(x2-x1+1);
        int y=r.nextInt(y2-y1+1);
        return new int[]{x+x1,y+y1};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */