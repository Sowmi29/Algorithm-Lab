
import java.util.*;

class Main {

    static class MergeSort {
        int[] arr;
        int[] arr1;

        MergeSort(int[] arr) {
            this.arr = arr;
            this.arr1 = new int[arr.length];
        }

        public void mergeSort(int low, int high) {
            if (low < high) {
                int mid = (low + high) / 2;
                mergeSort(low, mid);
                mergeSort(mid + 1, high);
                merge(low, mid, high);
            }
        }

        private void merge(int low, int mid, int high) {
            int pos = low, i = low, j = mid + 1;

            while (i <= mid && j <= high) {
                if (arr[i] < arr[j]) {
                    arr1[pos] = arr[i];
                    i++;
                } else {
                    arr1[pos] = arr[j];
                    j++;
                }
                pos++;
            }

            while (i <= mid) {
                arr1[pos] = arr[i];
                i++;
                pos++;
            }

            while (j <= high) {
                arr1[pos] = arr[j];
                j++;
                pos++;
            }

            for (int k = low; k <= high; k++) {
                arr[k] = arr1[k];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        MergeSort obj = new MergeSort(arr);
        obj.mergeSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}
