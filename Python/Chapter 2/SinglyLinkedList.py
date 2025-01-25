class SinglyLinkedList:

    class Node:
        def __init__(self, elem):
            self.elem = elem
            self.next = None

    def __init__(self):
        self.head = None

    # 1. Create a Linked List from an array
    def create_from_array(self, arr):
        if not arr:
            return
        self.head = self.Node(arr[0])
        current = self.head
        for elem in arr[1:]:
            current.next = self.Node(elem)
            current = current.next

    # 2. Iteration of the linked list
    def iterate(self):
        current = self.head
        while current:
            print(f"{current.elem} -> ", end="")
            current = current.next
        print()

    # 3. Count the items in the linked list
    def count(self):
        count = 0
        current = self.head
        while current:
            count += 1
            current = current.next
        return count

    # 4. Retrieve index of an element
    def index_of(self, elem):
        index = 0
        current = self.head
        while current:
            if current.elem == elem:
                return index
            current = current.next
            index += 1
        return -1  # Element not found

    # 5. Retrieve a node from an index
    def get_node(self, index):
        current_index = 0
        current = self.head
        while current:
            if current_index == index:
                return current
            current = current.next
            current_index += 1
        return None  # Index out of bounds

    # 6. Update value in a specific index
    def update(self, index, new_value):
        node = self.get_node(index)
        if node:
            node.elem = new_value
            return True
        return False  # Index out of bounds

    # 7. Search for an element in the list
    def search(self, elem):
        current = self.head
        while current:
            if current.elem == elem:
                return True
            current = current.next
        return False

    # 8. Insert a node in the list
    def insert(self, index, elem):
        new_node = self.Node(elem)
        if index == 0:  # Insert at the beginning
            new_node.next = self.head
            self.head = new_node
            return
        prev = self.get_node(index - 1)
        if prev:  # Insert in the middle or at the end
            new_node.next = prev.next
            prev.next = new_node

    # 9. Remove a node from the list
    def remove(self, index):
        if index == 0 and self.head:  # Remove from the beginning
            self.head = self.head.next
            return
        prev = self.get_node(index - 1)
        if prev and prev.next:  # Remove from the middle or end
            prev.next = prev.next.next

    # 10. Copying a linked list
    def copy(self):
        new_list = SinglyLinkedList()
        if not self.head:
            return new_list
        new_list.head = self.Node(self.head.elem)
        current = self.head.next
        new_current = new_list.head
        while current:
            new_current.next = self.Node(current.elem)
            current = current.next
            new_current = new_current.next
        return new_list

    # 11. Out-of-place reverse of a linked list
    def reverse_out_of_place(self):
        reversed_list = SinglyLinkedList()
        current = self.head
        while current:
            new_node = self.Node(current.elem)
            new_node.next = reversed_list.head
            reversed_list.head = new_node
            current = current.next
        return reversed_list

    # 12. In-place reverse of a linked list
    def reverse_in_place(self):
        prev = None
        current = self.head
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        self.head = prev

    # 13. Rotating the list left
    def rotate_left(self, k):
        if not self.head or k <= 0:
            return
        size = self.count()
        k = k % size  # Handle rotations greater than size
        if k == 0:
            return

        current = self.head
        for _ in range(k - 1):
            current = current.next

        new_head = current.next
        current.next = None

        tail = new_head
        while tail.next:
            tail = tail.next
        tail.next = self.head
        self.head = new_head

    # 14. Rotating the list right
    def rotate_right(self, k):
        if not self.head or k <= 0:
            return
        size = self.count()
        k = k % size  # Handle rotations greater than size
        if k == 0:
            return

        self.rotate_left(size - k)


# Driver Code for Testing
if __name__ == "__main__":
    list_ = SinglyLinkedList()

    # 1. Create a linked list from an array
    arr = [1, 2, 3, 4, 5]
    list_.create_from_array(arr)
    print("Original List:")
    list_.iterate()

    # 2. Iterate through the linked list
    print("Iterating through the list:")
    list_.iterate()

    # 3. Count the items in the linked list
    print(f"Count of items in the list: {list_.count()}")

    # 4. Retrieve index of an element
    elem_to_find = 3
    print(f"Index of element {elem_to_find}: {list_.index_of(elem_to_find)}")

    # 5. Retrieve a node from an index
    index_to_retrieve = 2
    node = list_.get_node(index_to_retrieve)
    print(
        f"Element at index {index_to_retrieve}: {node.elem if node else 'Index out of bounds'}"
    )

    # 6. Update value at a specific index
    index_to_update = 1
    new_value = 10
    if list_.update(index_to_update, new_value):
        print(f"Updated value at index {index_to_update} to {new_value}")
        list_.iterate()
    else:
        print(f"Failed to update index {index_to_update}")

    # 7. Search for an element in the list
    search_element = 4
    print(f"Element {search_element} found: {list_.search(search_element)}")

    # 8. Insert a node in the list
    print("Inserting 99 at index 0:")
    list_.insert(0, 99)
    list_.iterate()

    print("Inserting 77 at index 3:")
    list_.insert(3, 77)
    list_.iterate()

    print("Inserting 55 at the end:")
    list_.insert(list_.count(), 55)
    list_.iterate()

    # 9. Remove a node from the list
    print("Removing the node at index 2:")
    list_.remove(2)
    list_.iterate()

    # 10. Copying the linked list
    copied_list = list_.copy()
    print("Copied list:")
    copied_list.iterate()

    # 11. Out-of-place reverse of a linked list
    reversed_list = list_.reverse_out_of_place()
    print("Reversed list (out of place):")
    reversed_list.iterate()

    # 12. In-place reverse of a linked list
    list_.reverse_in_place()
    print("Reversed list (in place):")
    list_.iterate()

    # 13. Rotating the list left
    print("Rotating the list left by 2 positions:")
    list_.rotate_left(2)
    list_.iterate()

    # 14. Rotating the list right
    print("Rotating the list right by 2 positions:")
    list_.rotate_right(2)
    list_.iterate()
