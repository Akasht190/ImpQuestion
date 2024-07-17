class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int pfSum=0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            pfSum+=nums[i];

            int remainder=pfSum%k;
            if(remainder<0) remainder+=k;

            if(hm.containsKey(remainder)){
                count+=hm.get(remainder);
            }
            hm.put(remainder,hm.getOrDefault(remainder,0)+1);
        }
        return count;
    }
}