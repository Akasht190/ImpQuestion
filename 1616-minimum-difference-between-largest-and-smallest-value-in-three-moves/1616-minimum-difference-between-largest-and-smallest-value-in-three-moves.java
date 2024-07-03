class Solution {
    public int minDifference(int[] nums) {
       int n=nums.length;
       if(n<=4){
         return 0;
       }
       Arrays.sort(nums);
       int k=n-3;
       int ans=nums[n-1]-nums[0];
       for(int i=k-1;i<nums.length;i++){
          ans=Math.min(ans,nums[i]-nums[i-k+1]);
       }
       return ans;
    }
}