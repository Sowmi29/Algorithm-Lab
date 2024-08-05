import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
       
        System.out.print("Enter the number of test cases: ");
        int numTestCases = scanner.nextInt();

        // Validate input
        if (numTestCases <= 0) {
            System.out.println("Number of test cases must be greater than 0.");
            return;
        }

        List<Integer> sizes = new ArrayList<>();
        List<Integer> spaceComplexities = new ArrayList<>();
        List<Integer> timeComplexities = new ArrayList<>();
        List<Double> executionTimes = new ArrayList<>();

        for (int t = 0; t < numTestCases; t++) {
            System.out.print("Enter the size of the matrices (n x n) for test case " + (t + 1) + ": ");
            int n = scanner.nextInt();

            // Validate size
            if (n <= 0) {
                System.out.println("Matrix size must be greater than 0.");
                t--;
                continue;
            }

            int[][] matrix1 = new int[n][n];
            int[][] matrix2 = new int[n][n];

            System.out.println("Generating elements of the first matrix...");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix1[i][j] = random.nextInt(100);
                }
            }

            System.out.println("Generating elements of the second matrix...");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix2[i][j] = random.nextInt(100);
                }
            }

            int[][] resultMatrix = new int[n][n];

            // Measure execution time
            Instant start = Instant.now();
            int[] result = addMatrices(matrix1, matrix2, resultMatrix);
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            double executionTime = timeElapsed.toNanos() / 1_000_000_000.0; // Convert to seconds

            sizes.add(n);
            executionTimes.add(executionTime); 
            timeComplexities.add(result[0] + result[1]);
            spaceComplexities.add(result[2]);
            
            System.out.println("Resulting Matrix for test case " + (t + 1) + ":");
            printMatrix(resultMatrix);
        }

        // Print out data for verification
        System.out.println("Size (n x n) | Time Complexity (2n^2+2n+3) | Space Complexity (3n^2+3) | Execution Time (s)");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (int i = 0; i < sizes.size(); i++) {
            System.out.printf("%-13d | %-25d | %-26d | %-18.9f%n", 
                              sizes.get(i) , timeComplexities.get(i), spaceComplexities.get(i), executionTimes.get(i));
        }
    }

    public static int[] addMatrices(int[][] matrix1, int[][] matrix2, int[][] resultMatrix) {
        int c = 0, m = 0;
        int n = matrix1.length;
        int s = 3 + 3 * n * n; 

        c += 3; 

        for (int i = 0; i < n; i++) {
            m ++; // For loop increment and condition check
            for (int j = 0; j < n; j++) {
                m += 2; // For loop increment and condition check
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        m+=n;

        System.out.println("Time Complexity: C: " + c + " M: " + m);
        return new int[]{c, m, s};
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
