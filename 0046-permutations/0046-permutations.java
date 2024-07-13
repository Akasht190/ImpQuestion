class Solution {
    public void checkPtr(int ind,int[] nums,List<List<Integer>> result){
        if(ind==nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(nums,i,ind);
            checkPtr(ind+1,nums,result);
            swap(nums,i,ind);
        }
    }
    public void swap(int []nums,int left,int right){
        int t=nums[left];
        nums[left]=nums[right];
        nums[right]=t;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        checkPtr(0,nums,result);
        return result;
    }
}