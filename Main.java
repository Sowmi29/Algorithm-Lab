import java.util.*;
class Main{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
           arr[i]=scanner.nextInt();
        MergeSort obj = new MergeSort(arr,n);
        obj.mergeSort(0,n-1);
        for(int i=0;i<n;i++)
           System.out.print(arr[i]+" ");
    }
}
    