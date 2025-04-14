public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {30, 10, 50, 5, 20, 40, 60, 1};

        for (int val : values) bst.insert(val);

        System.out.print("In-order before deletion: ");
        bst.printInOrder();

        System.out.println("Searching 20: " + bst.search(20));
        System.out.println("Searching 100: " + bst.search(100));

        bst.deleteWithSuccessor(30);
        System.out.print("In-order after deleting 30 using successor: ");
        bst.printInOrder();

        bst.insert(30);
        bst.deleteWithPredecessor(50);
        System.out.print("In-order after deleting 50 using predecessor: ");
        bst.printInOrder();

        bst.balance();
        System.out.print("In-order after balancing: ");
        bst.printInOrder();
    }
}
