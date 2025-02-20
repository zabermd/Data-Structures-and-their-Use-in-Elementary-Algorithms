public class QueueOperations {

    // 1. Reverse a Queue
    public static LinkedListQueue reverseQueue(LinkedListQueue queue) {
        LinkedListStack stack = new LinkedListStack();
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        return queue;
    }

    // 2. Generate Binary Numbers using Queue
    public static void generateBinaryNumbers(int n) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);  // Start with "1"

        for (int i = 0; i < n; i++) {
            int front = queue.dequeue();
            System.out.print(front + " ");

            queue.enqueue(front * 10);     // Append "0" to front
            queue.enqueue(front * 10 + 1); // Append "1" to front
        }
        System.out.println();
    }

    // 3. Check if a given queue is a palindrome
    public static boolean isQueuePalindrome(LinkedListQueue queue) {
        LinkedListStack stack = new LinkedListStack();
        LinkedListQueue tempQueue = new LinkedListQueue();

        while (!queue.isEmpty()) {
            int elem = queue.dequeue();
            stack.push(elem);
            tempQueue.enqueue(elem);
        }

        while (!tempQueue.isEmpty()) {
            int qElem = tempQueue.dequeue();
            int sElem = stack.pop();
            if (qElem != sElem) {
                return false;
            }
        }
        return true;
    }
}
