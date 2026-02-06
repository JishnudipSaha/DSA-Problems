import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
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
}


public class InOrder {
    public List<Integer> inorderTraversaL(TreeNode root) {
        // using dfs to print inorder traversal
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // going left
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // processing node
            curr = stack.pop();
            result.add(curr.val);

            // going right
            curr = curr.right;
        }
        return result;
    }

    void inorder(TreeNode node, List<Integer> result){
        if (node == null) {
            return;
        }
        // going left
        inorder(node.left, result);

        // processing node
        result.add(node.val);

        //going right
        inorder(node.right, result);
    }
    public List<Integer> inorderTraversal(TreeNode root){
        // inorder using recursion
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    public static void main(String[] args) {
        
    }
}
