public class SinglyLinkedList {

    // Node class
    private static class Node {
        int elem;
        Node next;

        Node(int elem) {
            this.elem = elem;
            this.next = null;
        }
    }

    private Node head;

    // 1. Create a Linked List from an array
    public void createFromArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
    }

    // 2. Iteration of the linked list
    public void iterate() {
        Node current = head;
        while (current != null) {
            System.out.print(current.elem + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    // 3. Count the items in the linked list
    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // 4. Retrieve index of an element
    public int indexOf(int elem) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.elem == elem) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Element not found
    }

    // 5. Retrieve a node from an index
    public Node getNode(int index) {
        int currentIndex = 0;
        Node current = head;
        while (current != null) {
            if (currentIndex == index) {
                return current;
            }
            current = current.next;
            currentIndex++;
        }
        return null; // Index out of bounds
    }

    // 6. Update value in a specific index
    public boolean update(int index, int newValue) {
        Node node = getNode(index);
        if (node != null) {
            node.elem = newValue;
            return true;
        }
        return false; // Index out of bounds
    }

    // 7. Search for an element in the list
    public boolean search(int elem) {
        Node current = head;
        while (current != null) {
            if (current.elem == elem) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 8. Insert a node in the list
    public void insert(int index, int elem) {
        Node newNode = new Node(elem);
        if (index == 0) { // Insert at the beginning
            newNode.next = head;
            head = newNode;
            return;
        }
        Node prev = getNode(index - 1);
        if (prev != null) { // Insert in the middle or at the end
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    // 9. Remove a node from the list
    public void remove(int index) {
        if (index == 0 && head != null) { // Remove from the beginning
            head = head.next;
            return;
        }
        Node prev = getNode(index - 1);
        if (prev != null && prev.next != null) { // Remove from the middle or end
            prev.next = prev.next.next;
        }
    }

    // 10. Copying a linked list
    public SinglyLinkedList copy() {
        SinglyLinkedList newList = new SinglyLinkedList();
        if (head == null) return newList;
        newList.head = new Node(head.elem);
        Node current = head.next;
        Node newCurrent = newList.head;
        while (current != null) {
            newCurrent.next = new Node(current.elem);
            current = current.next;
            newCurrent = newCurrent.next;
        }
        return newList;
    }

    // 11. Out-of-place reverse of a linked list
    public SinglyLinkedList reverseOutOfPlace() {
        SinglyLinkedList reversedList = new SinglyLinkedList();
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.elem);
            newNode.next = reversedList.head;
            reversedList.head = newNode;
            current = current.next;
        }
        return reversedList;
    }

    // 12. In-place reverse of a linked list
    public void reverseInPlace() {
        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // 13. Rotating the list left
    public void rotateLeft(int k) {
        if (head == null || k <= 0) return;
        int size = count();
        k = k % size; // Handle rotations greater than size
        if (k == 0) return;

        Node current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }

        Node newHead = current.next;
        current.next = null;

        Node tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head = newHead;
    }

    // 14. Rotating the list right
    public void rotateRight(int k) {
        if (head == null || k <= 0) return;
        int size = count();
        k = k % size; // Handle rotations greater than size
        if (k == 0) return;

        rotateLeft(size - k);
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        // 1. Create a linked list from an array
        int[] arr = {1, 2, 3, 4, 5};
        list.createFromArray(arr);
        System.out.println("Original List:");
        list.iterate();

        // 2. Iterate through the linked list
        System.out.println("Iterating through the list:");
        list.iterate();

        // 3. Count the items in the linked list
        System.out.println("Count of items in the list: " + list.count());

        // 4. Retrieve index of an element
        int elemToFind = 3;
        System.out.println("Index of element " + elemToFind + ": " + list.indexOf(elemToFind));

        // 5. Retrieve a node from an index
        int indexToRetrieve = 2;
        Node node = list.getNode(indexToRetrieve);
        System.out.println("Element at index " + indexToRetrieve + ": " + (node != null ? node.elem : "Index out of bounds"));

        // 6. Update value at a specific index
        int indexToUpdate = 1;
        int newValue = 10;
        if (list.update(indexToUpdate, newValue)) {
            System.out.println("Updated value at index " + indexToUpdate + " to " + newValue);
            list.iterate();
        } else {
            System.out.println("Failed to update index " + indexToUpdate);
        }

        // 7. Search for an element in the list
        int searchElement = 4;
        System.out.println("Element " + searchElement + " found: " + list.search(searchElement));

        // 8. Insert a node in the list
        System.out.println("Inserting 99 at index 0:");
        list.insert(0, 99); // Insert at the beginning
        list.iterate();

        System.out.println("Inserting 77 at index 3:");
        list.insert(3, 77); // Insert in the middle
        list.iterate();

        System.out.println("Inserting 55 at the end:");
        list.insert(list.count(), 55); // Insert at the end
        list.iterate();

        // 9. Remove a node from the list
        System.out.println("Removing the node at index 2:");
        list.remove(2); // Remove from the middle
        list.iterate();

        // 10. Copying the linked list
        SinglyLinkedList copiedList = list.copy();
        System.out.println("Copied list:");
        copiedList.iterate();

        // 11. Out-of-place reverse of a linked list
        SinglyLinkedList reversedList = list.reverseOutOfPlace();
        System.out.println("Reversed list (out of place):");
        reversedList.iterate();

        // 12. In-place reverse of a linked list
        list.reverseInPlace();
        System.out.println("Reversed list (in place):");
        list.iterate();

        // 13. Rotating the list left
        System.out.println("Rotating the list left by 2 positions:");
        list.rotateLeft(2);
        list.iterate();

        // 14. Rotating the list right
        System.out.println("Rotating the list right by 2 positions:");
        list.rotateRight(2);
        list.iterate();


    }
}
