class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null ||nums.length<3){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Set<List<Integer>> ans=new HashSet<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            int j=i+1;
            int k=n-1;

            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }

                else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                else{
                    j++;
                }
            }
             
        }
        return new ArrayList<>(ans);
    }
}