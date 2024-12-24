class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        long zeroIndex=0;
        for(int num:nums){
            if(num==0){
              count++;
              zeroIndex+=count;
            }
            else{
                count=0;
            }
        }
        return zeroIndex;
    }
}