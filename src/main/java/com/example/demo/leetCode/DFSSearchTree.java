package com.example.demo.leetCode;

import com.example.demo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSSearchTree {
    public List<Integer> DFSByStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
