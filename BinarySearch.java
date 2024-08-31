import java.util.*;
class BinarySearch{
    public static int binSearch(int[] arr,int search,int low,int high){
        if(low>high)
           return -1;
        int mid = (low+high)/2;
        if(arr[mid]==search)
           return mid;
        else if(arr[mid]>search)
           return binSearch(arr,search,low,mid-1);
        return binSearch(arr,search,mid+1,high);
    }
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
           arr[i]=scanner.nextInt();
        
        int search = scanner.nextInt();

        int pos = binSearch(arr,search,0,n-1);
        System.out.println(pos != -1 ? "Element found at index: " + pos : "Element not found");

    }
}