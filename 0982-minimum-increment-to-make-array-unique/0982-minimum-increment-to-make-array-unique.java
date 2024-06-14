class Solution {
    public int minIncrementForUnique(int[] nums) {
       Arrays.sort(nums);
       int result=0;
       for(int i=1;i<nums.length;i++){
           if(nums[i-1]>=nums[i]){
               int diff=nums[i-1]-nums[i]+1;
               result+=diff;
               nums[i]+=diff;
           }
       } 
       return result;
    }
}