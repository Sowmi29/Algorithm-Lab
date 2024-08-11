/*
  Min Heap 
  finding kth smallest element
  DATE : 31/07/2024
 */
import java.util.*;
public class MinHeap{
   int[] arr;
   int n;
   int k;
   MinHeap(int[] arr,int n,int k){
    this.arr = arr;
    this.n = n;
    this.k = k;
   }

   void heapSort(){
     for(int i=n/2-1;i>=0;i--){
        heapify(n,i);
     }
     print("iyooo");
     for(int i=n-1;i>0;i--){
        swap(0,i);
        heapify(i,0);
        if(i==(n-k)){
          System.out.println("Kth smallest element : "+arr[i]);
        }
          
     }
     print("sorted");
   }
   
   int parent(int node){
    return (node/2)-1;
   }

   int leftChild(int node){
    return (node*2)+1;
   }

   int rightChild(int node){
    return (node*2)+2;
   }

   void swap(int l,int r){
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
   }

   void heapify(int s,int pos){
      int min = pos;
      int left = leftChild(pos);
      int right = rightChild(pos);

      if(left<s&&arr[left]<arr[min])
         min = left;

      if(right<s&&arr[right]<arr[min])
         min = right;

      if(min!=pos){
        swap(min,pos);
        heapify(s,min);
      }
   }
   
   void print(String s){
     System.out.println(s);
    for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
   }
   public static void main(String[] args){
     Scanner input = new Scanner(System.in);
     System.out.println("No. of elements ??");
     int n = input.nextInt();
     System.out.println("Enter "+n+" Numbers ");
     int[] arr= new int[n];
     for(int i=0;i<n;i++)
        arr[i]=input.nextInt();
     System.out.println("Enter K value : ");
     int k = input.nextInt();
     MinHeap obj = new MinHeap(arr,n,k);
     obj.heapSort();
    
   }
}