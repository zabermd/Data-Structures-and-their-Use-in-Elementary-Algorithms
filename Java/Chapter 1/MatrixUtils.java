public class ArrayUtils {

    // Iteration over an array
    public static void iterate(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Resize an array
    public static int[] resize(int[] arr, int newSize) {
        int[] resized = new int[newSize];
        for (int i = 0; i < Math.min(arr.length, newSize); i++) {
            resized[i] = arr[i];
        }
        return resized;
    }

    // Copy an array (pass by value)
    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    // Shift left (in-place)
    public static void shiftLeft(int[] arr) {
        if (arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0; // Fill the last position with 0
    }

    // Shift right (in-place)
    public static void shiftRight(int[] arr) {
        if (arr.length == 0) return;
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = 0; // Fill the first position with 0
    }

    // Rotate left (in-place)
    public static void rotateLeft(int[] arr) {
        if (arr.length == 0) return;
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }

    // Rotate right (in-place)
    public static void rotateRight(int[] arr) {
        if (arr.length == 0) return;
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    // Reverse array (Out-of-place)
    public static int[] reverseOutOfPlace(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    // Reverse array (In-place)
    public static void reverseInPlace(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Insert an element at the end or anywhere else
    public static int[] insert(int[] arr, int index, int value, int currentSize) {
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (currentSize == arr.length) {
            arr = resize(arr, arr.length * 2);
        }
        for (int i = currentSize; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        return arr;
    }

    // Delete the last element or any other element (in-place)
    public static void delete(int[] arr, int index, int currentSize) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < currentSize - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[currentSize - 1] = 0; // Set the last element to 0 after deletion
    }

    // Main method to test the utility class
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 0, 0};
        int currentSize = 5;

        System.out.print("Original array: ");
        iterate(array);

        System.out.print("Resized array: ");
        iterate(resize(array, 7));

        System.out.print("Copied array: ");
        iterate(copyArray(array));

        System.out.print("Shift left: ");
        shiftLeft(array);
        iterate(array);

        System.out.print("Shift right: ");
        shiftRight(array);
        iterate(array);

        System.out.print("Rotate left: ");
        rotateLeft(array);
        iterate(array);

        System.out.print("Rotate right: ");
        rotateRight(array);
        iterate(array);

        System.out.print("Reversed out-of-place: ");
        iterate(reverseOutOfPlace(array));

        reverseInPlace(array);
        System.out.print("Reversed in-place: ");
        iterate(array);

        System.out.print("After insertion: ");
        array = insert(array, 2, 10, currentSize);
        currentSize++;
        iterate(array);

        System.out.print("After deletion: ");
        delete(array, 2, currentSize);
        currentSize--;
        iterate(array);
    }
}
