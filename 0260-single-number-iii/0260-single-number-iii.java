class Solution {
    public int[] singleNumber(int[] nums) {
       int[] ans=new int[2];
       int n=nums.length;

       HashMap<Integer,Integer> hm=new HashMap<>();


       for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
       } 

       int count=0;
       for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
          if(entry.getValue()==1){
            ans[count]=entry.getKey();
            count++;
            if(count==2){
                break;
            }
          }
       }
       return ans;
    }
}