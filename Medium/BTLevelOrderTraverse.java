import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraverse {
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

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result  = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();  // Think of this as a collection of TreeNodes with the same level
        Queue<TreeNode> nextLevel = new LinkedList<>();
        List<Integer> tempResult = new ArrayList<>();
        TreeNode cur;
        
        // Start a modified BFS
        q.add(root);
        while (!q.isEmpty()) {
            // Clear a level before proceed
            while (!q.isEmpty()) {
                cur = q.poll();
                tempResult.add(cur.val);
                if (cur.left != null) nextLevel.add(cur.left);
                if (cur.right != null) nextLevel.add(cur.right);
            }

            // Update the queue and result
            result.add(new ArrayList<>());  // Can't add tempResult due to pass-by-reference (we'll clear tempResult)
            result.get(result.size()-1).addAll(tempResult);
            q.addAll(nextLevel);
            tempResult.clear();
            nextLevel.clear();
        }
        return result;
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result  = new ArrayList<>();
        
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;

        if (level == result.size()) result.add(new ArrayList<>());  // Initiate a new level
        result.get(level).add(root.val);

        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}
