
// Stack class using a singly linked list
class LinkedListStack {
    private Node top; // Points to the top element of the stack

    public LinkedListStack() {
        this.top = null; // Initialize stack as empty
    }

    // Push operation: Inserts an element at the top of the stack
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top; // New node points to the current top
        top = newNode; // Update top to the new node
    }

    // Pop operation: Removes and returns the top element of the stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow! Cannot pop from an empty stack.");
        }
        int poppedValue = top.elem;
        top = top.next; // Move top pointer to the next node
        return poppedValue;
    }

    // Peek operation: Returns the top element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty! Cannot peek.");
        }
        return top.elem;
    }

    // isEmpty operation: Checks if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display the stack contents (For debugging purposes)
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        Node current = top;
        System.out.print("Stack (top to bottom): ");
        while (current != null) {
            System.out.print(current.elem + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}
