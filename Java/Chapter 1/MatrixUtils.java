public class MatrixUtils {

    // 1. Creating a 2D array
    public static int[][] create2DArray(int rows, int cols, int initialValue) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = initialValue;
            }
        }
        return matrix;
    }

    // 2. Row-wise iteration
    public static void iterateRows(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // 3. Column-wise iteration
    public static void iterateColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 4. Sum of all values
    public static int sumAllValues(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
            }
        }
        return sum;
    }

    // 5. Sum of every row
    public static int[] sumRows(int[][] matrix) {
        int[] rowSums = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int value : matrix[i]) {
                sum += value;
            }
            rowSums[i] = sum;
        }
        return rowSums;
    }

    // 6. Sum of all columns
    public static int[] sumColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] colSums = new int[cols];
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += matrix[i][j];
            }
            colSums[j] = sum;
        }
        return colSums;
    }

    // 7. Swapping columns based on pattern in a matrix
    public static int[][] swapColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int mid = cols / 2;
        for (int j = 0; j < mid; j++) {
            int col1 = j;
            int col2 = cols - 1 - j;
            for (int i = 0; i < rows; i++) {
                int temp = matrix[i][col1];
                matrix[i][col1] = matrix[i][col2];
                matrix[i][col2] = temp;
            }
        }
        return matrix;
    }


    // 8. Adding primary diagonal items in a square matrix
    public static int sumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    // 9. Adding secondary diagonal items in a square matrix
    public static int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][n - 1 - i];
        }
        return sum;
    }

    // 10. Adding two matrices of the same dimension
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // 11. Matrix multiplication
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Main method to test the MatrixUtils class
    public static void main(String[] args) {
        int[][] matrix1 = create2DArray(3, 3, 1);
        int[][] matrix2 = create2DArray(3, 3, 2);

        System.out.println("Matrix 1:");
        iterateRows(matrix1);

        System.out.println("Matrix 2:");
        iterateRows(matrix2);

        System.out.println("Sum of all values in Matrix 1: " + sumAllValues(matrix1));

        System.out.println("Row-wise sums of Matrix 1:");
        int[] rowSums = sumRows(matrix1);
        for (int sum : rowSums) {
            System.out.print(sum + " ");
        }
        System.out.println();

        System.out.println("Column-wise sums of Matrix 1:");
        int[] colSums = sumColumns(matrix1);
        for (int sum : colSums) {
            System.out.print(sum + " ");
        }
        System.out.println();


        iterateRows(matrix1);

        System.out.println("Sum of primary diagonal of Matrix 2: " + sumPrimaryDiagonal(matrix2));
        System.out.println("Sum of secondary diagonal of Matrix 2: " + sumSecondaryDiagonal(matrix2));

        System.out.println("Addition of Matrix 1 and Matrix 2:");
        int[][] addedMatrix = addMatrices(matrix1, matrix2);
        iterateRows(addedMatrix);

        System.out.println("Multiplication of Matrix 1 and Matrix 2:");
        int[][] multipliedMatrix = multiplyMatrices(matrix1, matrix2);
        iterateRows(multipliedMatrix);

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Matrix before swapping columns:");
        iterateRows(matrix);
        matrix = swapColumns(matrix);

        System.out.println("Matrix after swapping columns:");
        iterateRows(matrix);
    }
}
