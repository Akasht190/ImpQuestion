class Solution {
    public int heightChecker(int[] heights) {
        int[] result=heights.clone();
        Arrays.sort(result);

        int count=0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=result[i]){
                count++;
            }
        }
        return count;
    }
}