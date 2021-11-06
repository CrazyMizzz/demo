package com.example.demo.leetCode;

import com.example.demo.util.TreeNode;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTSearchTree_102 {

    public static void main(String args[]) {
        TreeNode root = TreeNode.initTree(null,
                new TreeNode(0),
                new TreeNode(2),
                new TreeNode(4),
                new TreeNode(1),
                null,
                new TreeNode(3),
                new TreeNode(-1),
                new TreeNode(5),
                new TreeNode(1),
                null,
                new TreeNode(6),
                null,
                new TreeNode(8));
        System.out.println(new Gson().toJson(levelOrder(root)));
    }

    /**
     * useBFS
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode tmp;
            TreeNode flag = null;
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                tmp = queue.poll();
                if (flag != null && flag == tmp) {
                    lists.add(new ArrayList<>(list));
                    list.clear();
                    flag = null;
                }
                list.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                    if (flag == null) {
                        flag = tmp.left;
                    }
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                    if (flag == null) {
                        flag = tmp.right;
                    }
                }
            }
            lists.add(new ArrayList<>(list));
        }
        return lists;
    }

    /**
     * use DFS
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        levelHelper(res, root, 0);
//        return res;
//    }
//
//    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
//        if (root == null) return;
//        if (height >= res.size()) {
//            res.add(new LinkedList<Integer>());
//        }
//        res.get(height).add(root.val);
//        levelHelper(res, root.left, height+1);
//        levelHelper(res, root.right, height+1);
//
//    }
}
