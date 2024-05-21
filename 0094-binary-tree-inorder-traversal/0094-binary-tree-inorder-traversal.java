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
    public void inorder(List<Integer> ans,TreeNode root){
        if(root==null) return;
        inorder(ans,root.left);
        ans.add(root.val);
        inorder(ans,root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
       if(root==null) return new ArrayList<>(Arrays.asList());

       List<Integer> ans=new ArrayList<>();
       inorder(ans,root.left);
       ans.add(root.val);
       inorder(ans,root.right);
       return ans; 
    }
}