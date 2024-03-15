import java.util.*;
public class ASS2_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < T; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int r = scanner.nextInt();

            // Read matrix A
            int[][] A = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    A[j][k] = scanner.nextInt();
                }
            }

            // Read matrix B
            int[][] B = new int[p][q];
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < q; k++) {
                    B[j][k] = scanner.nextInt();
                }
            }

            // Perform matrix operation
            if (r == 0) {
                int[][] result = multiplyMatrices(A, B);
                printMatrix(result);
            } else {
                int[][] result = addMatrices(A, B);
                printMatrix(result);
            }

            // Print an extra line to separate the output between two test cases
            if (i < T - 1) {
                System.out.println();
            }
        }

        scanner.close();
    }

    private static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    private static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
