class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = 0, maxRight = 0;
        if (root.left != null) maxLeft = maxDepth(root.left);
        if (root.right != null) maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }
}