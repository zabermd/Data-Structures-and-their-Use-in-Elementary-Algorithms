public class Main {
    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();

        // 1. Creating a Linked List from an array
        int[] arr = {10, 20, 30, 40, 50};
        list.createFromArray(arr);

        // 2. Iteration of the linked list
        System.out.println("Iterating the list:");
        list.iterate();

        // 3. Count the items in the linked list
        System.out.println("Count of items: " + list.countItems());

        // 4. Retrieving a node from an index
        int indexToRetrieve = 2;
        Node node = list.getNode(indexToRetrieve);
        if (node != null) {
            System.out.println("Element at index " + indexToRetrieve + ": " + node.elem);
        } else {
            System.out.println("Index " + indexToRetrieve + " is out of bounds.");
        }

        // 5. Inserting a node in the list (start, middle, end)
        System.out.println("Inserting 5 at the start:");
        list.insertAtStart(5);
        list.iterate();

        System.out.println("Inserting 60 at the end:");
        list.insertAtEnd(60);
        list.iterate();

        System.out.println("Inserting 25 at index 3:");
        list.insertAtIndex(3, 25);
        list.iterate();

        // 6. Removing a node from the list
        System.out.println("Removing the node at index 4:");
        list.remove(4);
        list.iterate();
    }
}
