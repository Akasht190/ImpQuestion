class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //TC-O(N^2) sc-o(1)
        // int n=nums.length;
        // int ans=0;

        // for(int i=0;i<n;i++){
        //     int max=nums[i];
        //     for(int j=i;j<n;j++){
        //         max=Math.max(max,nums[j]);

        //         if(max>=left && max<=right){
        //             ans++;
        //         }
        //     }
        // }
        // return ans;


        int n=nums.length;
        int i=0;
        int ans=0;
        int j=0;
        int prev=0;
        while(j<n){
            if(nums[j]>=left && nums[j]<=right){
               prev=j-i+1;
               ans+=prev;
            }
            else if(nums[j]<left){
                ans+=prev;
            }
            else{
                i=j+1;
                prev=0;
            }
            j++;
        }
        return ans;
    }
}