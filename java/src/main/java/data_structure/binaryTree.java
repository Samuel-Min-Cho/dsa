import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTree {

  static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  TreeNode root;

  // Build -------------------------------------------------------
  // Queue level order / bfs input
  void build(int[] arr) {
    // -1 = null
    if (arr.length == 0 || arr[0] == -1) return;
    root = new TreeNode(arr[0]);
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int i = 1;
    while (!q.isEmpty() && i < arr.length) {
      TreeNode curr = q.poll();
      // left
      if (arr[i] != -1) {
        curr.left = new TreeNode(arr[i]);
        q.add(curr.left);
        i++;
      }
      // right
      if (i < arr.length && arr[i] != -1) {
        curr.right = new TreeNode(arr[i]);
        i++;
      }
    }
  }

  // BST insert: Recursive insertion into BST
  TreeNode insert(TreeNode root, int val) {
    // null checkup
    if (root == null) return new TreeNode(val);

    // building tree
    if (val < root.val) root.left = insert(root.left, val);
    else root.right = insert(root.right, val);
    return root;
  }

  // Traversal ----------------------------------------------------
  // Inorder traversal: Left -> ROOT -> right (sorted order in BST)
  void inorder(TreeNode root, List<Integer> result) {
    // null checkup
    if (root == null) return;

    inorder(root.left, result);
    result.add(root.val);
    inorder(root.right, result);
  }

  // Pre-Order : root -> Left -> right (used for copying tree)
  void preorder(TreeNode root, List<Integer> result) {
    if (root == null) return;

    result.add(root.val);
    preorder(root.left, result);
    preorder(root.right, result);
  }

  // post-order : left -> right -> root (used for deleting tree)
  void postorder(TreeNode root, List<Integer> result) {
    if (root == null) return;

    postorder(root.left, result);
    postorder(root.right, result);
    result.add(root.val);
  }

  public static void main(String argc[]) {
    binaryTree tree = new binaryTree();
    int[] arr = new int[] {1, 2, 3, 4, 5, -1, 7};
    List<Integer> result;

    tree.build(arr);
    tree.inorder(tree.root, result);
  }
}
