class Solution {
    public int[][] merge(int[][] intervals) {
         Arrays.sort(intervals,(a,b)->a[0]-b[0]);
         List<int[]> ans=new ArrayList<>();

         int a=intervals[0][0];
         int b=intervals[0][1];

         for(int[] temp:intervals){
            if(temp[0]<=b){
                b=Math.max(b,temp[1]);
            }else{
                ans.add(new int[]{a,b});
                a=temp[0];
                b=temp[1];
            }
         }
         ans.add(new int[]{a,b});
         return ans.toArray(new int[0][1]);
    }
}