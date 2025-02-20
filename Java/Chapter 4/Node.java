package ChapterFour;

// Node class with generic key-value types
public class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}