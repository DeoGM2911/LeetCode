public class MinAbsDiffBST {
    class TreeNode {
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

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        int minDiff = Integer.MAX_VALUE;
        TreeNode next;
        if (root.left != null) {

            minDiff = getMinimumDifference(root.left);
            // The closet element to the root on the left branch
            next = root.left;
            while (next.right != null) {
                next = next.right;
            }
            minDiff = Math.min(minDiff, root.val - next.val);
        }
        if (root.right != null) {
            minDiff = Math.min(minDiff, getMinimumDifference(root.right));
            // The closet element to the root on the right branch
            next = root.right;
            while (next.left != null) {
                next = next.left;
            }
            minDiff = Math.min(minDiff, next.val - root.val);
        }
        return minDiff;
    }
}