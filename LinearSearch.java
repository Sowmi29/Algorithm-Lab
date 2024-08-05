import java.time.*;
import java.util.*;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Number of test cases: ");
        int numTestCases = scanner.nextInt();

        if (numTestCases <= 0) {
            System.out.println("Number of test cases must be greater than 0.");
            return;
        }

        List<Integer> sizes = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> m = new ArrayList<>();
        List<Double> executionTimes = new ArrayList<>();

        for (int t = 0; t < numTestCases; t++) {
            System.out.print("Enter the size of the array for test case " + (t + 1) + ": ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.out.println("Size must be greater than 0.");
                t--; 
                continue;
            }

            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(10); // Random integers between 0 and 9
            }

            System.out.println("Elements of the array for TestCase " + (t + 1) + ": " + Arrays.toString(arr));
            System.out.print("Enter the target value for test case " + (t + 1) + ": ");
            int target = scanner.nextInt();

            // Measure execution time
            Instant start = Instant.now();
            int[] result = linearSearch(arr, target);
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            double executionTime = timeElapsed.toNanos();
            
            c.add(result[0]);
            m.add(result[1]);
            sizes.add(size);
            counts.add(result[0] + result[1]); // m + c
            executionTimes.add(executionTime); // Store execution time
        }

        // Print out data for verification
       System.out.println("Size (n) | Space (n+3) | TimeComplexity (c+2m) | Count (m+c) | Execution Time (s)");
System.out.println("-------------------------------------------------------------------------------");
for (int i = 0; i < sizes.size(); i++) {
    System.out.printf("%-8d | %-11d | %d + 2(%d)        | %-13d | %-18.9f%n",
            sizes.get(i), sizes.get(i) + 3, c.get(i), sizes.get(i), counts.get(i), executionTimes.get(i));
}
    }

    public static int[] linearSearch(int[] arr, int target) {
        int c = 0;
        int m = 0;
        int result = -1;
        c++;
        m++;

        for (int i = 0; i < arr.length; i++) {
            m += 2;
            if (arr[i] == target) {
                c++;
                result = i;
                break;  
            }
        }

        c++;
        if (result != -1) {
            c++;
        } else {
            System.out.println("Not Found");
            c++;
        }

        if (m % 2 != 0) {
            c++;
            m--;
        }

    //    System.out.println("TIME COMPLEXITY : " + c + " + 2m = " + c + " + 2(" + arr.length + ") = " + c + " + " + m + " = " + (c + m));

        return new int[] {c, m};
    }
}
