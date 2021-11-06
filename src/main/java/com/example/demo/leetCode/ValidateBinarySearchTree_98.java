package com.example.demo.leetCode;

import com.example.demo.util.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree_98 {
    public static void main(String args[]) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        Double tmp = Double.MIN_VALUE;
        System.out.println(tmp.toString());
//        System.out.println(isValidWithStack(TreeNode.initTree(null, node1, node2, node3, null, null, node4, node5)));
//        TreeNode node1 = new TreeNode();
    }

//    public static boolean isValidBST(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        isValidWithStack(root, list);
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i) >= list.get(i + 1)) {
//                return false;
//            }
//        }
//        return true;
//
//    }


    public static boolean isValidWithStack(TreeNode root) {
        Integer tmp = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (tmp != null && tmp >= root.val) {
                return false;
            }
            tmp = root.val;
            root = root.right;
        }
        return true;
    }

    //    public static void isValidBSTREE(TreeNode root, List<Integer> list) {
//        if (root != null) {
//            isValidBSTREE(root.right, list);
//            list.add(root.val);
//            isValidBSTREE(root.left, list);
//        }
//    }
}
