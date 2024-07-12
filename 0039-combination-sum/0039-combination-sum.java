class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,target,0,new ArrayList<>(),0,ans);
        return ans;
    }
    public void helper(int[] candidates,int target,int ind,List<Integer> temp,int total,List<List<Integer>> ans){
        if(total==target){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        if(total>target || ind>=candidates.length){
            return;
        }
        temp.add(candidates[ind]);
        helper(candidates,target,ind,temp,total+candidates[ind],ans);
        temp.remove(temp.size()-1);
        helper(candidates,target,ind+1,temp,total,ans);
    }
}