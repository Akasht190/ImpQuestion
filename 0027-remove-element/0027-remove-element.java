class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        Arrays.sort(nums);
        int ind=0;

        for(int i=0;i<n;i++){
            if(nums[i]!=val){
                nums[ind]=nums[i];
                ind++;
            }
        }
        return ind;
    }
}