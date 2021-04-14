package com.company.tree;

public class MinSum {
    public int minSum(TreeNode root) {
        int res = 0;
        if (root == null)
            return 0;
        res += root.val;
        if (root.left != null && root.right != null)
            res += Math.max(minSum(root.left), minSum(root.right));
        else if (root.left == null)
            res += minSum(root.right);
        else
            res += minSum(root.left);
        return res;
    }
}
