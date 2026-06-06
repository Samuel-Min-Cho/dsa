import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class trees {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Recursive insertion into BST
    TreeNode insert(TreeNode root, int val) {
        // null checkup
        if (root == null)
            return new TreeNode(val);

        // building tree
        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }

    // Inorder traversal
    void inorder(TreeNode node, List<Integer> result) {
        // null checkup
        if (node == null)
            return;

        // left to right traversal
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    // BFS (level-order) using a QUEUE (root left right)
    void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null)
                q.offer(curr.left);
            if (curr.right != null)
                q.offer(curr.right);
        }
    }

    public static void main(String argc[]) {

    }
}
