package com.example.demo.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public Integer getVal() {
        return this.val;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setLeftTreeNode(int val, TreeNode left) {
        this.val = val;
        this.left = left;
    }

    public void setRightTreeNode(int val, TreeNode right) {
        this.val = val;
        this.right = right;
    }

    public static TreeNode initTree(TreeNode... node) {
        TreeNode[] nodes = node;
        int length = nodes.length;
        int i = 1;
        while (i < length) {
            if (nodes[i] != null) {
                if (2 * i < length)
                    nodes[i].left = nodes[2 * i];
                if ((i * i + 1) < length)
                    nodes[i].right = nodes[2 * i + 1];
            }
            i++;
        }
        return nodes[1];
    }

}
