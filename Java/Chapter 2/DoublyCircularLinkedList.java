public class DoublyCircularLinkedList {
    private Node head;

    public DoublyCircularLinkedList() {
        head = new Node(-1); // Dummy node
        head.next = head;
        head.prev = head;
    }

    // 1. Creating a Linked List from an array
    public void createFromArray(int[] arr) {
        for (int elem : arr) {
            insertAtEnd(elem);
        }
    }

    // 2. Iteration of the linked list
    public void iterate() {
        Node current = head.next;
        while (current != head) {
            System.out.print(current.elem + " ");
            current = current.next;
        }
        System.out.println();
    }

    // 3. Count the items in the linked list
    public int countItems() {
        int count = 0;
        Node current = head.next;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }

    // 4. Retrieving a node from an index (Index starts from 0)
    public Node getNode(int index) {
        if (index < 0) return null;

        Node current = head.next;
        int currentIndex = 0;

        while (current != head) {
            if (currentIndex == index) return current;
            currentIndex++;
            current = current.next;
        }
        return null; // Index out of bounds
    }

    // 5. Inserting a node in the list (start, middle, end)
    public void insertAtStart(int elem) {
        Node newNode = new Node(elem);
        Node first = head.next;

        newNode.next = first;
        newNode.prev = head;
        head.next = newNode;
        first.prev = newNode;
    }

    public void insertAtEnd(int elem) {
        Node newNode = new Node(elem);
        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;
    }

    public void insertAtIndex(int index, int elem) {
        if (index < 0) return;

        if (index == 0) {
            insertAtStart(elem);
            return;
        }

        Node current = head.next;
        int currentIndex = 0;

        while (current != head) {
            if (currentIndex == index) {
                Node newNode = new Node(elem);
                Node prevNode = current.prev;

                newNode.next = current;
                newNode.prev = prevNode;
                prevNode.next = newNode;
                current.prev = newNode;

                return;
            }
            currentIndex++;
            current = current.next;
        }

        if (currentIndex == index) { // Insert at the end
            insertAtEnd(elem);
        }
    }

    // 6. Removing a node from the list
    public void remove(int index) {
        if (index < 0) return;

        Node current = head.next;
        int currentIndex = 0;

        while (current != head) {
            if (currentIndex == index) {
                Node prevNode = current.prev;
                Node nextNode = current.next;

                prevNode.next = nextNode;
                nextNode.prev = prevNode;

                return;
            }
            currentIndex++;
            current = current.next;
        }
        System.out.println("Index out of bounds");
    }
}
