class MaxHeap:
    def __init__(self, capacity):
        self.capacity = capacity
        self.heap = [0] * capacity
        self.size = 0

    def insert(self, value):
        if self.size == self.capacity:
            print("Heap is full")
            return
        self.heap[self.size] = value
        self._swim(self.size)
        self.size += 1

    def _swim(self, index):
        while index > 0 and self.heap[index] > self.heap[self._parent(index)]:
            self._swap(index, self._parent(index))
            index = self._parent(index)

    def _parent(self, index):
        return (index - 1) // 2

    def delete_max(self):
        if self.size == 0:
            raise IndexError("Heap is empty")
        max_val = self.heap[0]
        self._swap(0, self.size - 1)
        self.size -= 1
        self._heapify(0)
        return max_val

    def _heapify(self, index):
        largest = index
        left = 2 * index + 1
        right = 2 * index + 2

        if left < self.size and self.heap[left] > self.heap[largest]:
            largest = left
        if right < self.size and self.heap[right] > self.heap[largest]:
            largest = right

        if largest != index:
            self._swap(index, largest)
            self._heapify(largest)

    def _swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def heap_sort(self):
        original_size = self.size
        for i in range(self.size - 1, 0, -1):
            self._swap(0, i)
            self.size -= 1
            self._heapify(0)
        self.size = original_size

    def print_heap(self):
        print(self.heap[:self.size])

    def print_sorted(self):
        self.heap_sort()
        print(self.heap[:self.size])


# === Test Code ===
if __name__ == "__main__":
    max_heap = MaxHeap(10)
    max_heap.insert(10)
    max_heap.insert(20)
    max_heap.insert(5)
    max_heap.insert(7)
    max_heap.insert(30)
    max_heap.insert(15)

    print("Heap:")
    max_heap.print_heap()

    print("Deleted Max:", max_heap.delete_max())

    print("Heap After Deletion:")
    max_heap.print_heap()

    print("Heap Sort:")
    max_heap.print_sorted()
