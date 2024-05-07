class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int left=0;
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int right=0;right<n;right++){
           hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);
           while(hm.get(nums[right])>k){
             hm.put(nums[left],hm.get(nums[left])-1);
             left++;
           }
           max=Math.max(max,right-left+1);
        }
      return max;
    }
}
// // class Solution {
//     public int maxSubarrayLength(int[] nums, int k) {
//         int ans = 0;
//         HashMap<Integer, Integer> mp = new HashMap<>();
//         int l = 0;

//         for (int r = 0; r < nums.length; r++) {
//             mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
//             while (mp.get(nums[r]) > k) {
//                 mp.put(nums[l], mp.get(nums[l]) - 1);
//                 l++;
//             }
//             ans = Math.max(ans, r - l + 1);
//         }

//         return ans;
//     }
// }