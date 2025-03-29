public class SameTree {
    private class TreeNode {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return false;

        if (q.val == p.val) {
            if(!isSameTree(p.left, q.left)) return false;
            if (!isSameTree(p.right, q.right)) return false;
            return true;
        }
        return false;
    }
}
