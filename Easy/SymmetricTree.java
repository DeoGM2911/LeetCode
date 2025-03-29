public class SymmetricTree {
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
    public boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root2 == null && root1 != null) return false;
        if (root1.val != root2.val) return false;
        if (sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right)) return true;
        return false;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recurse for the children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode copyTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = copyTree(root.left);
        newRoot.right = copyTree(root.right);
        return newRoot;
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode copy = copyTree(root);
        TreeNode invertRoot = invertTree(root);
        return sameTree(copy.left, invertRoot.left);
    }
}
