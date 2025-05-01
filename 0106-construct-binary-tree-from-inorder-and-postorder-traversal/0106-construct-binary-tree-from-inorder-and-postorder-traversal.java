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
    private int postOrderIndex;
    private Map<Integer, Integer> hm;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        postOrderIndex = postorder.length - 1;
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(rootVal);

        int mid = hm.get(rootVal);

        // \U0001f501 Important: build right first, then left
        root.right = build(postorder, mid + 1, end);
        root.left = build(postorder, start, mid - 1);

        return root;
    }
}
