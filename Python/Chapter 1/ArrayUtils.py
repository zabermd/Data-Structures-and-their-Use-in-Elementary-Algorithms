import numpy as np

class ArrayUtils:

    @staticmethod
    def iterate(arr):
        for element in arr:
            print(element, end=" ")
        print()

    @staticmethod
    def resize(arr, new_size):
        resized = np.zeros(new_size, dtype=arr.dtype)
        for i in range(min(len(arr), new_size)):
            resized[i] = arr[i]
        return resized

    @staticmethod
    def copy_array(arr):
        copy = np.zeros_like(arr)
        for i in range(len(arr)):
            copy[i] = arr[i]
        return copy

    @staticmethod
    def shift_left(arr):
        for i in range(len(arr) - 1):
            arr[i] = arr[i + 1]
        arr[-1] = 0

    @staticmethod
    def shift_right(arr):
        for i in range(len(arr) - 1, 0, -1):
            arr[i] = arr[i - 1]
        arr[0] = 0

    @staticmethod
    def rotate_left(arr):
        first = arr[0]
        for i in range(len(arr) - 1):
            arr[i] = arr[i + 1]
        arr[-1] = first

    @staticmethod
    def rotate_right(arr):
        last = arr[-1]
        for i in range(len(arr) - 1, 0, -1):
            arr[i] = arr[i - 1]
        arr[0] = last

    @staticmethod
    def reverse_out_of_place(arr):
        reversed_array = np.zeros_like(arr)
        for i in range(len(arr)):
            reversed_array[i] = arr[len(arr) - 1 - i]
        return reversed_array

    @staticmethod
    def reverse_in_place(arr):
        left, right = 0, len(arr) - 1
        while left < right:
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
            right -= 1

    @staticmethod
    def insert(arr, index, value, current_size):
        if index < 0 or index > current_size:
            raise IndexError("Invalid index")
        if current_size == len(arr):
            arr = ArrayUtils.resize(arr, len(arr) * 2)
        for i in range(current_size, index, -1):
            arr[i] = arr[i - 1]
        arr[index] = value
        return arr

    @staticmethod
    def delete(arr, index, current_size):
        if index < 0 or index >= current_size:
            raise IndexError("Invalid index")
        for i in range(index, current_size - 1):
            arr[i] = arr[i + 1]
        arr[current_size - 1] = 0


# Example usage
if __name__ == "__main__":
    array = np.array([1, 2, 3, 4, 5, 0, 0], dtype=int)
    current_size = 5

    print("Original array: ", end="")
    ArrayUtils.iterate(array)

    print("Resized array: ", end="")
    resized = ArrayUtils.resize(array, 10)
    ArrayUtils.iterate(resized)

    print("Copied array: ", end="")
    copied = ArrayUtils.copy_array(array)
    ArrayUtils.iterate(copied)

    print("Shift left: ", end="")
    ArrayUtils.shift_left(array)
    ArrayUtils.iterate(array)

    print("Shift right: ", end="")
    ArrayUtils.shift_right(array)
    ArrayUtils.iterate(array)

    print("Rotate left: ", end="")
    ArrayUtils.rotate_left(array)
    ArrayUtils.iterate(array)

    print("Rotate right: ", end="")
    ArrayUtils.rotate_right(array)
    ArrayUtils.iterate(array)

    print("Reversed out-of-place: ", end="")
    reversed_out = ArrayUtils.reverse_out_of_place(array)
    ArrayUtils.iterate(reversed_out)

    print("Reversed in-place: ", end="")
    ArrayUtils.reverse_in_place(array)
    ArrayUtils.iterate(array)

    print("After insertion: ", end="")
    array = ArrayUtils.insert(array, 2, 10, current_size)
    current_size += 1
    ArrayUtils.iterate(array)

    print("After deletion: ", end="")
    ArrayUtils.delete(array, 2, current_size)
    current_size -= 1
    ArrayUtils.iterate(array)
