class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return helper(nums, upper + 1) - helper(nums, lower);
    }
    private long helper(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        long count = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target) {
                count += (r - l);
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}