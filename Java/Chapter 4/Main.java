package ChapterFour;

// Main class for testing
public class Main {
    public static void main(String[] args) {
        HashTable<Object, Object> hashTable = new HashTable<>(5);

        // Insert key-value pairs
        hashTable.insert(12, "Apple");
        hashTable.insert(5, "Orange");
        hashTable.insert(17, "Banana");
        hashTable.insert(10, "Grapes");
        hashTable.insert(22, "Watermelon");
        hashTable.insert(15, "Pineapple");

        // Insert a duplicate key with a different value
        hashTable.insert(10, "Updated Grapes");  // Should update the value

        // Display the hash table
        hashTable.display();

        // Search for a key
        System.out.println("Search for key 17: " + hashTable.search(17));
        System.out.println("Search for key 10: " + hashTable.search(10));  // Should return "Updated Grapes"
        System.out.println("Search for key 8: " + hashTable.search(8));    // Should return null
    }
}