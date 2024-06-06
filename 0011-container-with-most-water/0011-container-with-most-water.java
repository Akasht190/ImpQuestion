class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;

        int currentArea=0;
        int maxArea=Integer.MIN_VALUE;
        while(left<right){
            currentArea=Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(currentArea,maxArea);

            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;

    }
}