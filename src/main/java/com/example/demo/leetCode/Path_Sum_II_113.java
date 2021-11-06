package com.example.demo.leetCode;

import com.example.demo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Path_Sum_II_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        sum(root, 0, sum, new ArrayList<>(), lists);
        return lists;
    }

    public void sum(TreeNode root, int sum, int target, List<Integer> list, List<List<Integer>> lists) {
        if (root != null) {
            if (sum < target) {
                if (root.left == null && root.right == null) {
                    if ((sum + root.val) == target) {
                        List<Integer> newList = new ArrayList<>(list);
                        newList.add(root.val);
                        lists.add(newList);
                    }
                } else {
                    list.add(root.val);
                    sum(root.left, sum + root.val, target, new ArrayList<>(list), lists);
                    sum(root.right, sum + root.val, target, new ArrayList<>(list), lists);
                }
            }
        }
    }

    public void DFSSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Integer tmpS = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                tmpS += root.val;
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
            if (root == null) {
                if (tmpS == sum) {
                    lists.add(new ArrayList<>(list));
                }
                int index=list.size()-1;
                tmpS-=list.get(index);
                list.remove(index);
            }
        }
    }

}
