class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i=0;
        while(i<n){
            int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        int ans[] = new int[2];
        for(int j=0; j<n; j++){
            if(nums[j]!=j+1){
                ans[0]=nums[j];
                ans[1]=j+1;
            }
        }
        return ans;
    }
}