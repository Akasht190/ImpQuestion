/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<TreeNode>> dp=new ArrayList<>();
    public List<TreeNode> allPossibleFBT(int n) {
        for(int i=0;i<=n;i++){
            dp.add(new ArrayList<>());
        }
       return  helper(n);
    }

    public List<TreeNode> helper(int n){
        if(n%2==0){
            return new ArrayList<>();
        }

        if(!dp.get(n).isEmpty()){
            return dp.get(n);
        }
        if(n==1){
            ArrayList<TreeNode> ans=new ArrayList<>();
            ans.add(new TreeNode(0));
            return ans;
        }

        List<TreeNode> result=new ArrayList<>();

        for(int i=1;i<n;i+=2){
            List<TreeNode> left=helper(i);
            List<TreeNode> right=helper(n-i-1);

            for(TreeNode l:left){
                for(TreeNode r:right){
                  TreeNode root=new TreeNode(0);
                  root.left=l;
                  root.right=r;
                  result.add(root);
                }
            }
        }
        dp.set(n,result);
        return result;
    }
}