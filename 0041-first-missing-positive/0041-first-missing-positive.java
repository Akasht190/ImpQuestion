class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hm=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                hm.add(nums[i]);
            }
        }
        int res=1;
        while(hm.contains(res)){
            res++;
        }
        return res;
    }
}