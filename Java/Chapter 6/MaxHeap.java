public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Insert into Max Heap
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        swim(size);
        size++;
    }

    // Swim up to maintain heap property
    private void swim(int index) {
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Delete the max (root) element
    public int deleteMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0];
        swap(0, size - 1);
        size--;
        heapify(0);
        return max;
    }

    // Heapify down to maintain heap property
    private void heapify(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && heap[left] > heap[largest])
            largest = left;
        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    // Swap helper
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Heap sort (in-place)
    public void heapSort() {
        int originalSize = size;
        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            heapify(0);
        }
        size = originalSize;
    }

    // Display heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Display array after sorting
    public void printSorted() {
        heapSort();
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(7);
        maxHeap.insert(30);
        maxHeap.insert(15);

        System.out.println("Heap:");
        maxHeap.printHeap();

        System.out.println("Deleted Max: " + maxHeap.deleteMax());

        System.out.println("Heap After Deletion:");
        maxHeap.printHeap();

        System.out.println("Heap Sort:");
        maxHeap.printSorted();
    }
}

