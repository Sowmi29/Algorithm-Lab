import java.util.Scanner;

public class Floyd {
    static final int INF = Integer.MAX_VALUE; 

    static void floydWarshall(int dist[][], int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && 
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist, n);
    }

    static void printSolution(int dist[][], int n) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter the adjacency matrix (use -1 for infinity):");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int input = scanner.nextInt();
                graph[i][j] = (input == -1 && i != j) ? INF : input;
            }
        }
        floydWarshall(graph, n);
    }
}
