class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       HashMap<Integer,Integer> hm=new HashMap<>();
       int n=nums.length;
       for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
              int index=hm.get(nums[i]);
              if(Math.abs(i-index)<=k){
                return true;
              }
              hm.put(nums[i],i);
            }else{
                hm.put(nums[i],i);
            }
       }
       return false;
    }
}