import stack
class Node:
    def __init__(self, elem):
        self.elem = elem
        self.next = None

class LinkedListQueue:
    def __init__(self):
        self.front = self.rear = None

    def enqueue(self, elem):
        new_node = Node(elem)
        if self.rear is None:
            self.front = self.rear = new_node
            return
        self.rear.next = new_node
        self.rear = new_node

    def dequeue(self):
        if self.is_empty():
            raise IndexError("Queue is empty")
        removed_elem = self.front.elem
        self.front = self.front.next
        if self.front is None:
            self.rear = None
        return removed_elem

    def peek(self):
        if self.is_empty():
            raise IndexError("Queue is empty")
        return self.front.elem

    def is_empty(self):
        return self.front is None

    def display_queue(self):
        current = self.front
        print("Queue (front to rear):", end=" ")
        while current:
            print(f"{current.elem} ->", end=" ")
            current = current.next
        print("NULL")

class QueueOperations:

    @staticmethod
    def reverse_queue(queue):
        st = stack.LinkedListStack() # Using our Predefined Stack Class
        while not queue.is_empty():
            st.push(queue.dequeue())
        while st.is_empty() != False:
            queue.enqueue(st.pop())
        return queue

    @staticmethod
    def generate_binary_numbers(n):
        queue = LinkedListQueue()
        queue.enqueue(1)

        for _ in range(n):
            front = queue.dequeue()
            print(front, end=" ")
            queue.enqueue(front * 10)
            queue.enqueue(front * 10 + 1)
        print()

    @staticmethod
    def is_queue_palindrome(queue):
        st = stack.LinkedListStack() # Using our Predefined Stack Class
        temp_queue = LinkedListQueue()

        while not queue.is_empty():
            elem = queue.dequeue()
            st.push(elem)
            temp_queue.enqueue(elem)

        while not temp_queue.is_empty():
            if temp_queue.dequeue() != st.pop():
                return False
        return True

if __name__ == "__main__":
    queue = LinkedListQueue()
    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)
    print("Original Queue:")
    queue.display_queue()

    queue = QueueOperations.reverse_queue(queue)
    print("Reversed Queue:")
    queue.display_queue()

    print("Binary Numbers up to 5:")
    QueueOperations.generate_binary_numbers(5)

    palindrome_queue = LinkedListQueue()
    palindrome_queue.enqueue(1)
    palindrome_queue.enqueue(2)
    palindrome_queue.enqueue(3)
    palindrome_queue.enqueue(2)
    palindrome_queue.enqueue(1)

    print("Is the queue a palindrome?", QueueOperations.is_queue_palindrome(palindrome_queue))
