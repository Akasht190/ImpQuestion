class Solution {
    //one more time
    public int jump(int[] nums) {
       int maxReach=0;
       int minJumps=0;
       int currentEnd=0;

       for(int i=0;i<nums.length-1;i++){
         if(i+nums[i]>maxReach){
            maxReach=i+nums[i];
         }

         if(i==currentEnd){
            minJumps++;
            currentEnd=maxReach;
         }
       }
       return  minJumps;
    }
}