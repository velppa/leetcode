package principle_of_recurtion;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SearchInBinarySearchTree {

    @Test
    public void test1(){
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1),
                new TreeNode(3)), new TreeNode(6, new TreeNode(5), new TreeNode(7, null,
                new TreeNode(9, new TreeNode(8), new TreeNode(10)))));

        //System.out.println(searchBST(root, 11));
        assertEquals(new TreeNode(10), searchBST(root, 10));
        assertEquals(new TreeNode(8), searchBST(root, 8));
        assertEquals(new TreeNode(3), searchBST(root, 3));
        assertNull(searchBST(root, 16));

    }


    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val){
            return root;
        } else if (val < root.val){
            return root.left == null ? null : searchBST(root.left, val);
        } else {
            return root.right == null ? null : searchBST(root.right, val);
        }
    }


    // Definition for a binary tree node.
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TreeNode treeNode = (TreeNode) o;

            if (val != treeNode.val) return false;
            if (!Objects.equals(left, treeNode.left)) return false;
            return Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }
    }

}
