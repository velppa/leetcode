package _7_Unique_Binary_Search_Trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

    @Test
    public void testTreeNode() {
        System.out.println(new Solution().generateTrees(5));
    }

    // Definition for a binary tree node.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"val\": " + val +
                    "," +
                    "\"right\": " + right +
                    ",\"left\": " + left +
                    '}';
        }
    }

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0)
                return null;

            return nodeProcessor(1, n);
        }

        public List<TreeNode> nodeProcessor(int m, int n) {
            List<TreeNode> nodeList = new ArrayList<>();
            if (m > n) {
                nodeList.add(null);
                return nodeList;
            }


            for (int i = m; i <= n; i++) {
                List<TreeNode> leftList = nodeProcessor(m, i - 1);
                List<TreeNode> rightList = nodeProcessor(i + 1, n);
                for (TreeNode l : leftList) {
                    for (TreeNode r : rightList) {
                        TreeNode tn = new TreeNode(i);
                        tn.left = l;
                        tn.right = r;
                        nodeList.add(tn);
                    }
                }
            }
            return nodeList;
        }

    }


}
