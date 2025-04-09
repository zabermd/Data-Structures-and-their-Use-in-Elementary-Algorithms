public class BinaryTree {
    TreeNode root;

    // 1. Create a binary tree from array (ignoring index 0)
    public TreeNode createTreeFromArray(int[] arr, int i) {
        if (i >= arr.length) return null;
        TreeNode node = new TreeNode(arr[i]);
        node.left = createTreeFromArray(arr, 2 * i);
        node.right = createTreeFromArray(arr, 2 * i + 1);
        return node;
    }

    // 2. Depth of a node
    public int depth(TreeNode root, int key, int d) {
        if (root == null) return -1;
        if (root.elem == key) return d;

        int left = depth(root.left, key, d + 1);
        if (left != -1) return left;

        return depth(root.right, key, d + 1);
    }

    // 3. Height of a node
    public int height(TreeNode node) {
        if (node == null) return -1;
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }

    // 4. Number of nodes
    public int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // 5. Full binary tree check
    public boolean isFull(TreeNode node) {
        if (node == null) return true;
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) return false;
        return isFull(node.left) && isFull(node.right);
    }

    // 6. Complete binary tree check
    public boolean isComplete(TreeNode node, int index, int totalNodes) {
        if (node == null) return true;
        if (index > totalNodes) return false;
        return isComplete(node.left, 2 * index, totalNodes) &&
                isComplete(node.right, 2 * index + 1, totalNodes);
    }

    // 7. Perfect binary tree check
    public boolean isPerfect(TreeNode node, int depth, int level) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return depth == level;
        if (node.left == null || node.right == null) return false;
        return isPerfect(node.left, depth, level + 1) &&
                isPerfect(node.right, depth, level + 1);
    }

    // 8. Balanced binary tree check
    public boolean isBalanced(TreeNode node) {
        return checkBalance(node) != -1;
    }

    private int checkBalance(TreeNode node) {
        if (node == null) return 0;
        int left = checkBalance(node.left);
        int right = checkBalance(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    // MAIN for testing
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7}; // index 0 ignored
        bt.root = bt.createTreeFromArray(arr, 1);

        System.out.println("Depth of 6: " + bt.depth(bt.root, 6, 0));
        System.out.println("Height of root: " + bt.height(bt.root));
        System.out.println("Number of nodes: " + bt.countNodes(bt.root));
        System.out.println("Is Full: " + bt.isFull(bt.root));
        System.out.println("Is Complete: " + bt.isComplete(bt.root, 1, bt.countNodes(bt.root)));
        System.out.println("Is Perfect: " + bt.isPerfect(bt.root, bt.height(bt.root), 0));
        System.out.println("Is Balanced: " + bt.isBalanced(bt.root));
    }
}
