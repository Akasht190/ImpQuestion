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
    private int preOrderIndex=0;
    private Map<Integer,Integer> hm;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }

        preOrderIndex=0;
        return build(preorder,0,preorder.length-1);
    }

    public TreeNode build(int[] preOrder,int start,int end){
        if(start>end){
            return null;
        }

        int rootVal=preOrder[preOrderIndex++];
        TreeNode root=new TreeNode(rootVal);
        int mid=hm.get(rootVal);
        root.left=build(preOrder,start,mid-1);
        root.right=build(preOrder,mid+1,end);
        return root;
    }
}