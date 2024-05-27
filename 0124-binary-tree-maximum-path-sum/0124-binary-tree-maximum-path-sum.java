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
    int maxSum=0;
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int lh=dfs(root.left);
        int rh=dfs(root.right);
        //SUM SHOULD BE POSITIVE NUMBER THAT'S WHY WE COMPARE WITH 0;
        lh=Math.max(lh,0);
        rh=Math.max(rh,0);

        int currSum=root.val+lh+rh;
        maxSum=Math.max(maxSum,currSum);

        return root.val+Math.max(lh,rh);
    }
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
}