package com.example.demo.leetCode;

import com.example.demo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Recover_Binary_Search_Tree_99 {
    public static void main(String args[]) {
        TreeNode[] nodes = new TreeNode[10000];
        for (int i = 0; i < 10000; i++) {
            nodes[i] = new TreeNode(i + 1);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            recoverTree(TreeNode.initTree(nodes));
        }
        System.out.println(System.currentTimeMillis() - start);
//        TreeNode node1 = new TreeNode();
    }

    public static void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        returnArray(list, root);
        nomalSort(list);
//        quickSort(0,list.size()-1,list);
    }

    public static void nomalSort(List<TreeNode> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).val > list.get(j).val) {
                    int a = list.get(i).val;
                    list.get(i).val = list.get(j).val;
                    list.get(j).val = a;
                }
            }
        }
    }

    public static void quickSort(int low, int high, List<TreeNode> arr) {
        int i, j, t;
        TreeNode temp;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        temp = arr.get(low);
        while (i < j) {
            //先看右边，依次往左递减
            while (temp.val < arr.get(j).val && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp.val > arr.get(i).val && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr.get(j).val;
                arr.get(j).val = arr.get(i).val;
                arr.get(i).val = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr.get(low).val = arr.get(i).val;
        arr.get(i).val = temp.val;
        //递归调用左半数组
        quickSort(low, j - 1, arr);
        //递归调用右半数组
        quickSort(j + 1, high, arr);
    }

    public static void returnArray(List<TreeNode> inorderTreeList, TreeNode root) {
        if (root != null) {
            returnArray(inorderTreeList, root.left);
            inorderTreeList.add(root);
            returnArray(inorderTreeList, root.right);
        }
    }
}
