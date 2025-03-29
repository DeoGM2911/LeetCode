import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {
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
    public List<Integer> rightSideViewBFS(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result  = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();  // Think of this as a collection of TreeNodes with the same level
        Queue<TreeNode> nextLevel = new LinkedList<>(); 
        TreeNode cur;
        TreeNode node;
        
        // Start a modified BFS
        q.add(root);
        while (!q.isEmpty()) {
            cur = q.poll();
            result.add(cur.val);
            // Always add right child first
            if (cur.right != null) nextLevel.add(cur.right);
            if (cur.left != null) nextLevel.add(cur.left);

            // Explore potential nodes
            while (!q.isEmpty()) {
                node = q.poll();
                // Always add right child first
                if (node.right != null) nextLevel.add(node.right);
                if (node.left != null) nextLevel.add(node.left);
            }

            // Update the queue
            q.addAll(nextLevel);
            nextLevel.clear();
        }
        return result;
    }

    public List<Integer> rightSideViewDFS(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result  = new ArrayList<>();
        dfs(root, 0, result);  // Level 0
        return result;
    }

    public void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;

        // Guarantees we only add one element for each level exactly once
        if (level == result.size()) {
            result.add(root.val);
        }

        // Recurse on children. Priority for right child
        dfs(root.right, level + 1, result);
        dfs(root.left, level + 1, result);
    }
}