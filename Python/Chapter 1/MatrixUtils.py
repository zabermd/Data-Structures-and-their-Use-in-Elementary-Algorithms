import numpy as np

class MatrixUtils:
    @staticmethod
    def create_2d_array(rows, cols, initial_value=0):
        # Create a 2D array with zeros using np.zeros
        matrix = np.zeros((rows, cols), dtype=int)
        
        # If initial_value is not zero, update all elements
        if initial_value != 0:
            for i in range(rows):
                for j in range(cols):
                    matrix[i][j] = initial_value
                    
        return matrix.tolist()

    @staticmethod
    def iterate_rows(matrix):
        for row in matrix:
            print(row)

    @staticmethod
    def iterate_columns(matrix):
        rows = len(matrix)
        cols = len(matrix[0])
        for j in range(cols):
            for i in range(rows):
                print(matrix[i][j], end=" ")
            print()

    @staticmethod
    def sum_all_values(matrix):
        total = 0
        for row in matrix:
            for value in row:
                total += value
        return total

    @staticmethod
    def sum_rows(matrix):
        row_sums = []
        for row in matrix:
            row_sums.append(sum(row))
        return row_sums

    @staticmethod
    def sum_columns(matrix):
        rows = len(matrix)
        cols = len(matrix[0])
        col_sums = [0] * cols
        for j in range(cols):
            for i in range(rows):
                col_sums[j] += matrix[i][j]
        return col_sums

    @staticmethod
    def swap_columns(matrix):
        rows = len(matrix)
        cols = len(matrix[0])
        for i in range(rows):
            for j in range(cols // 2):
                # Swap columns (0 ⇌ n-1, 1 ⇌ n-2, etc.)
                temp = matrix[i][j]
                matrix[i][j] = matrix[i][cols - 1 - j]
                matrix[i][cols - 1 - j] = temp
        return matrix

    @staticmethod
    def sum_primary_diagonal(matrix):
        total = 0
        for i in range(len(matrix)):
            total += matrix[i][i]
        return total

    @staticmethod
    def sum_secondary_diagonal(matrix):
        total = 0
        n = len(matrix)
        for i in range(n):
            total += matrix[i][n - 1 - i]
        return total

    @staticmethod
    def add_matrices(matrix1, matrix2):
        rows = len(matrix1)
        cols = len(matrix1[0])
        result = np.zeros((rows, cols), dtype=int)
        for i in range(rows):
            for j in range(cols):
                result[i][j] = matrix1[i][j] + matrix2[i][j]
        return result.tolist()

    @staticmethod
    def multiply_matrices(matrix1, matrix2):
        rows1 = len(matrix1)
        cols1 = len(matrix1[0])
        cols2 = len(matrix2[0])
        result = np.zeros((rows1, cols2), dtype=int)
        for i in range(rows1):
            for j in range(cols2):
                for k in range(cols1):
                    result[i][j] += matrix1[i][k] * matrix2[k][j]
        return result.tolist()


# Example Usage
if __name__ == "__main__":
    matrix1 = MatrixUtils.create_2d_array(3, 3, 1)
    matrix2 = MatrixUtils.create_2d_array(3, 3, 2)

    print("Matrix 1:")
    MatrixUtils.iterate_rows(matrix1)

    print("\nMatrix 2:")
    MatrixUtils.iterate_rows(matrix2)

    print("\nSum of all values in Matrix 1:", MatrixUtils.sum_all_values(matrix1))

    print("\nRow-wise sums of Matrix 1:")
    row_sums = MatrixUtils.sum_rows(matrix1)
    print(row_sums)

    print("\nColumn-wise sums of Matrix 1:")
    col_sums = MatrixUtils.sum_columns(matrix1)
    print(col_sums)

    print("\nSum of primary diagonal of Matrix 2:", MatrixUtils.sum_primary_diagonal(matrix2))
    print("Sum of secondary diagonal of Matrix 2:", MatrixUtils.sum_secondary_diagonal(matrix2))

    print("\nAddition of Matrix 1 and Matrix 2:")
    added_matrix = MatrixUtils.add_matrices(matrix1, matrix2)
    MatrixUtils.iterate_rows(added_matrix)

    print("\nMultiplication of Matrix 1 and Matrix 2:")
    multiplied_matrix = MatrixUtils.multiply_matrices(matrix1, matrix2)
    MatrixUtils.iterate_rows(multiplied_matrix)

    print("\nMatrix before swapping columns:")
    test_matrix = [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9, 10, 11, 12],
        [13, 14, 15, 16]
    ]
    MatrixUtils.iterate_rows(test_matrix)

    print("\nMatrix after swapping columns:")
    swapped_matrix = MatrixUtils.swap_columns(test_matrix)
    MatrixUtils.iterate_rows(swapped_matrix)
