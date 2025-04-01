import java.util.HashMap;

public class BTfromPreOrderInOrder {
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

    HashMap<Integer, Integer> pos = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Boost searching time
        for (int i = 0; i < preorder.length; i++) {
            pos.put(inorder[i], i);
        }

        return constructTree(preorder, inorder, 0, 0, inorder.length);
    }
    
    public TreeNode constructTree(int[] preorder, int[] inorder, int rootIdx, int start, int end) {
        // start and end are starting and ending indices of inorder
        if (start >= end) return null;

        TreeNode root = new TreeNode(preorder[rootIdx]);
        root.left = constructTree(preorder, inorder, rootIdx + 1, start, pos.get(preorder[rootIdx]));
        root.right = constructTree(preorder, inorder, rootIdx + pos.get(preorder[rootIdx]) - start + 1, pos.get(preorder[rootIdx]) + 1, end);
        
        return root;
    }
}
