# Node class to store key-value pairs in the linked list (collision handling)
class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

# HashTable class implementing Forward Chaining
class HashTable:
    def __init__(self, size):
        self.size = size
        self.table = [None] * size  # Array of linked lists

    # Hash function using modulus operation
    def hash_function(self, key):
        return abs(hash(key)) % self.size  # Ensure positive index

    # Insert method (updates value if key exists)
    def insert(self, key, value):
        index = self.hash_function(key)
        current = self.table[index]

        # Check if key exists and update value
        while current:
            if current.key == key:
                current.value = value  # Update value for existing key
                return
            current = current.next

        # Insert at the beginning (Forward Chaining)
        new_node = Node(key, value)
        new_node.next = self.table[index]
        self.table[index] = new_node

    # Search method
    def search(self, key):
        index = self.hash_function(key)
        current = self.table[index]

        while current:
            if current.key == key:
                return current.value
            current = current.next
        return None  # Key not found

    # Display method
    def display(self):
        for i in range(self.size):
            print(f"Index {i}:", end=" ")
            current = self.table[i]
            while current:
                print(f"({current.key}, {current.value}) ->", end=" ")
                current = current.next
            print("NULL")

# Main function for testing
if __name__ == "__main__":
    hash_table = HashTable(5)

    # Insert key-value pairs
    hash_table.insert(12, "Apple")
    hash_table.insert(5, "Orange")
    hash_table.insert(17, "Banana")
    hash_table.insert(10, "Grapes")
    hash_table.insert(22, "Watermelon")
    hash_table.insert(15, "Pineapple")

    # Insert a duplicate key with a different value (should update)
    hash_table.insert(10, "Updated Grapes")  

    # Display the hash table
    hash_table.display()

    # Search for a key
    print("Search for key 17:", hash_table.search(17))
    print("Search for key 10:", hash_table.search(10))  # Should return "Updated Grapes"
    print("Search for key 8:", hash_table.search(8))    # Should return None
