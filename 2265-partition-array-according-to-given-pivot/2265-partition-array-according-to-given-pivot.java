class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result=new int[nums.length];
        int ind=0;

        for(int i:nums){
            if(i<pivot){
                result[ind++]=i;
            }
        }

        for(int i:nums){
            if(i==pivot){
                result[ind++]=i;
            }
        }
        for(int i:nums){
            if(i>pivot){
                result[ind++]=i;
            }
        }
        return result;
    }
}