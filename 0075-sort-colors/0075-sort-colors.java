class Solution {
    public void sortColors(int[] nums) {
       int n=nums.length;
       int c0=0,c1=0,c2=0;
       for(int i=0;i<n;i++){
         if(nums[i]==0) c0++;
         else if(nums[i]==1) c1++;
         else c2++;
       }

       for(int i=0;i<n;i++){
        if(c0!=0){
            nums[i]=0;
            c0--;
        }
        else if(c1!=0){
            nums[i]=1;
            c1--;
        }
        else{
            nums[i]=2;
            c2--;
        }
       }
    }
}