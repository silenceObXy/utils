package com.example.utilsdemo.leetcode.tree;

/**
 * @Author: xy
 * @Date: 2025-02-14 09:38
 * @Description:
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
        return root;
    }


}
