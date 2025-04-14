public class BinarySearchTree {
    Node root;

    // Insert an element
    public void insert(int elem) {
        root = insertRecursive(root, elem);
    }

    private Node insertRecursive(Node node, int elem) {
        if (node == null) return new Node(elem);
        if (elem < node.elem) node.left = insertRecursive(node.left, elem);
        else if (elem > node.elem) node.right = insertRecursive(node.right, elem);
        return node;
    }

    // Search for an element
    public boolean search(int elem) {
        return searchRecursive(root, elem);
    }

    private boolean searchRecursive(Node node, int elem) {
        if (node == null) return false;
        if (elem == node.elem) return true;
        if (elem < node.elem) return searchRecursive(node.left, elem);
        else return searchRecursive(node.right, elem);
    }

    // Delete using Inorder Successor
    public void deleteWithSuccessor(int elem) {
        root = deleteSuccessorRecursive(root, elem);
    }

    private Node deleteSuccessorRecursive(Node node, int elem) {
        if (node == null) return null;
        if (elem < node.elem) node.left = deleteSuccessorRecursive(node.left, elem);
        else if (elem > node.elem) node.right = deleteSuccessorRecursive(node.right, elem);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node successor = findMin(node.right);
            node.elem = successor.elem;
            node.right = deleteSuccessorRecursive(node.right, successor.elem);
        }
        return node;
    }

    // Delete using Inorder Predecessor
    public void deleteWithPredecessor(int elem) {
        root = deletePredecessorRecursive(root, elem);
    }

    private Node deletePredecessorRecursive(Node node, int elem) {
        if (node == null) return null;
        if (elem < node.elem) node.left = deletePredecessorRecursive(node.left, elem);
        else if (elem > node.elem) node.right = deletePredecessorRecursive(node.right, elem);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node predecessor = findMax(node.left);
            node.elem = predecessor.elem;
            node.left = deletePredecessorRecursive(node.left, predecessor.elem);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node findMax(Node node) {
        while (node.right != null) node = node.right;
        return node;
    }

    // Balance the BST
    public void balance() {
        int[] sorted = toSortedArray();
        root = buildBalancedBST(sorted, 0, sorted.length - 1);
    }

    private Node buildBalancedBST(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = buildBalancedBST(arr, start, mid - 1);
        node.right = buildBalancedBST(arr, mid + 1, end);
        return node;
    }

    // Convert BST to sorted array using in-order traversal
    private int[] toSortedArray() {
        int size = countNodes(root);
        int[] result = new int[size];
        fillArray(root, result, new int[]{0});
        return result;
    }

    private void fillArray(Node node, int[] arr, int[] index) {
        if (node == null) return;
        fillArray(node.left, arr, index);
        arr[index[0]++] = node.elem;
        fillArray(node.right, arr, index);
    }

    private int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Print in-order traversal
    public void printInOrder() {
        printInOrderRecursive(root);
        System.out.println();
    }

    private void printInOrderRecursive(Node node) {
        if (node == null) return;
        printInOrderRecursive(node.left);
        System.out.print(node.elem + " ");
        printInOrderRecursive(node.right);
    }
}
