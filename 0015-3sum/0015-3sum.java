class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length<3){
            return new ArrayList<>();
        }

      Set<List<Integer>> res=new HashSet<>();
      Arrays.sort(nums);
      for(int i=0;i<nums.length-2;i++){
        int j=i+1;
        int k=nums.length-1;
        while(j<k){
            int sum=nums[i]+nums[j]+nums[k];
            if(sum==0){
              res.add(Arrays.asList(nums[i],nums[j],nums[k]));
              j++;
              k--;
            }
            else if(sum>0){
                k--;
            }else{
                j++;
            }
        }
        
      }
      return new ArrayList<>(res);
    }
}