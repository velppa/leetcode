package principle_of_recurtion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static principle_of_recurtion.MaximumDepthOfBinaryTree.TreeNode;

public class MaximumDepthOfBinaryTree2 {
    
    @Test
    public void test(){
        TreeNode root1 = new TreeNode(3,new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1,null, new TreeNode(2));
        TreeNode root3 = new TreeNode(1,new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null), null);

        assertEquals(3, maxDepth(root1));
        assertEquals(2, maxDepth(root2));
        assertEquals(5, maxDepth(root3));
    }

    public int maxDepth(TreeNode root) {
        int[] maxCounter = new int[1];
        nodeSearcher(root, 0, maxCounter);
        return maxCounter[0];
    }

    public int nodeSearcher(TreeNode root, int levelCounter, int[] maxCounter){
        if(root == null){
            return 0;
        }

        levelCounter++;
        if(levelCounter > maxCounter[0]){
            maxCounter[0] = levelCounter;
        }

        return nodeSearcher(root.left, levelCounter, maxCounter) + nodeSearcher(root.right, levelCounter, maxCounter);
    }
}
