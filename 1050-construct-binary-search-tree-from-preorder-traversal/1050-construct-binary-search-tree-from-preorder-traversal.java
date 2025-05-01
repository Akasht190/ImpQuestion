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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null || preorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        Stack<TreeNode> st=new Stack<>();
        st.push(root);

        int i=1;
        while(i<preorder.length){
            TreeNode node=new TreeNode(preorder[i]);
            TreeNode curr=st.peek();

            if(node.val<curr.val){
                curr.left=node;
            }
            else{
                while(!st.isEmpty() && node.val>st.peek().val){
                    curr=st.pop();
                }
                curr.right=node;
            }
            st.push(node);
            i++;
        }
        return root;
    }
}