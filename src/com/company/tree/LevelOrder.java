package com.company.tree;

import com.company.list.ListNode;

import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> res = levelOrder.levelOrder(TreeNode.createTree());
        System.out.println(res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(1, res, root);
        return res;
    }

    private void dfs(int level, List<List<Integer>> res, TreeNode node) {
        if (res.size() < level)
            res.add(new ArrayList<>());
        res.get(level - 1).add(node.val);
        if (node.left != null)
            dfs(level + 1, res, node.left);
        if (node.right != null)
            dfs(level + 1, res, node.right);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer (root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<TempNode> list = new ArrayList<>();
        list.add(new TempNode(0, root));
        while (!list.isEmpty()) {
            TempNode temp = list.remove(0);
            List<Integer> tempList = map.get(temp.level);
            if (tempList == null) {
                tempList = new ArrayList<>();
                map.put(temp.level, tempList);
            }
            tempList.add(temp.treeNode.val);

            if (temp.treeNode.left != null)
                list.add(new TempNode(temp.level + 1, temp.treeNode.left));
            if (temp.treeNode.right != null)
                list.add(new TempNode(temp.level + 1, temp.treeNode.right));
        }

        map.forEach((k, v) -> {
           res.add(k, v);
        });
        return res;
    }

}



class TempNode {
    int level;
    TreeNode treeNode;

    public TempNode(int level, TreeNode treeNode) {
        this.level = level;
        this.treeNode = treeNode;
    }
}
