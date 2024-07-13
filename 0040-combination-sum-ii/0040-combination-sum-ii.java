class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(candidates,target,0,result,temp);
        return result;
    }

    public void helper(int[] candidates,int target,int ind,List<List<Integer>> result,List<Integer> temp){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return ;
        }
        if(target<0){
            return ;
        }

        for(int i=ind;i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1]){
                continue;
            }
            if(target<candidates[i]){
                break;
            }
            temp.add(candidates[i]);
            helper(candidates,target-candidates[i],i+1,result,temp);
            temp.remove(temp.size()-1);

        }
    }
}