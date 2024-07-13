class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(0,candidates,target,temp,res);
        return res;
    }

    public void helper(int ind,int[] candidates,int target,List<Integer> temp,List<List<Integer>> res){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<Integer>(temp));
            return ;
        }

        for(int i=ind;i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            temp.add(candidates[i]);
            helper(i+1,candidates,target-candidates[i],temp,res);
            temp.remove(temp.size()-1);
        }
    }
}