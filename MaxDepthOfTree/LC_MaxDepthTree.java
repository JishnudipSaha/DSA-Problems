package MaxDepthOfTree;
// import java.util.*;

public class LC_MaxDepthTree {

    public int maxDepth(TreeNode root) {
        // Base condition
        if (root == null) {
            return 0;
        }

        // Recursively find depth of left and right
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Current node adds 1 level
        return 1 + Math.max(leftDepth, rightDepth);
    }


    public static void main(String[] args) {
        // TreeNode treeNode = new TreeNode();
    }
}
