import java.util.*;

public class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
           arr[i]=scanner.nextInt();
        quickSort(arr, 0, n - 1);
        printArray(arr);
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

   
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            
            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
            }
        }

     
        swap(arr, low, right);
        return right;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
