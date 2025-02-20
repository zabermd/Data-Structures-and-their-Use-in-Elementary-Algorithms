package ChapterFour;

// HashTable class with generic key-value support and duplicate key handling
public class HashTable<K, V> {
    private int size;
    private Node<K, V>[] table;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.size = size;
        table = new Node[size];
    }

    // Hash function (modulus operation)
    private int hashFunction(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    // Insert method (prevents duplicate keys and updates value if key exists)
    public void insert(K key, V value) {
        int index = hashFunction(key);
        Node<K, V> current = table[index];

        // Check if the key already exists and update its value
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;  // Update value for existing key
                return;
            }
            current = current.next;
        }

        // Insert at the beginning of the linked list (forward chaining)
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    // Search method
    public V search(K key) {
        int index = hashFunction(key);
        Node<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;  // Key not found
    }

    // Display method
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            Node<K, V> current = table[i];
            while (current != null) {
                System.out.print("(" + current.key + ", " + current.value + ") -> ");
                current = current.next;
            }
            System.out.println("NULL");
        }
    }
}
