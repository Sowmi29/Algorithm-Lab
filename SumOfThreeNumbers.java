import java.util.*;
import java.time.*;

public class SumOfThreeNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.print("Number of test cases? ");
        int testCases = input.nextInt();
          
        if(testCases<=0)
          return;

        List<Integer> sums = new ArrayList<>();
        List<Double> executionTimes = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        List<Integer> space = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int c = random.nextInt(100);
           System.out.println("TestCase " + (t + 1) + ": "+a+" "+b+" "+c);
           
            Instant start = Instant.now();
            int sum = calculateSum(a,b,c);
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            double executionTime = timeElapsed.toNanos();

            sums.add(sum);
            count.add(1);
            space.add(3);
            executionTimes.add(executionTime); 
        }

        
        System.out.println("Test Case | Sum | Execution Time | TimeComplexity | SpaceComplexity");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < sums.size(); i++) {
            System.out.printf("%-9d | %-3d | %-14.9f | %-14d | %-18d%n", i + 1, sums.get(i), executionTimes.get(i),count.get(i),space.get(i));
        }
    }

    public static int calculateSum(int a, int b, int c) {
        return a + b + c;
    }
}
