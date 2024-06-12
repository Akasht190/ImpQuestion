class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
         Set<Integer> set=new HashSet<>();
         for(int i:nums){
            set.add(i);
         }

         ArrayList<Integer> ans=new ArrayList<>();
         for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
         }
         return ans;
    }
}