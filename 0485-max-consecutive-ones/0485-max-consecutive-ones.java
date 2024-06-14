class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
      int ans=0;
      int max=0;
      int n=nums.length;
      for(int i=0;i<n;i++){
          if(nums[i]==0){
               ans=0;
          }else{
            ans++;
            max=Math.max(ans,max);
          }
      }
      return max;
    }
}