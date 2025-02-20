//Main class to test the stack implementation
public class MainStack {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        // Testing push operation
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.displayStack(); // Output: Stack (top to bottom): 30 -> 20 -> 10 -> NULL

        // Testing peek operation
        System.out.println("Top element: " + stack.peek()); // Output: 30

        // Testing pop operation
        System.out.println("Popped: " + stack.pop()); // Output: 30
        stack.displayStack(); // Output: Stack (top to bottom): 20 -> 10 -> NULL

        // Checking if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        // Popping remaining elements
        stack.pop();
        stack.pop();

        // Checking if stack is empty after all pops
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
    }
}
