import java.util.Scanner;

public class KnapSack {
    public static int knapsack(int W, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        System.out.print("Enter the maximum weight of the knapsack: ");
        int W = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

      
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
            System.out.print("Enter value of item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

      
        int maxValue = knapsack(W, weights, values, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);

        scanner.close();
    }
}
