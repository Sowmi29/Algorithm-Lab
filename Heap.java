/*
  Max Heap 
  Heap Sorting
  DATE : 31/07/2024
 */
import java.util.*;
public class Heap{
   int[] arr;
   int n;
   Heap(int[] arr,int n){
    this.arr = arr;
    this.n = n;
   }

   void heapSort(){
     print("Before");
     for(int i=n/2-1;i>=0;i--){
        heapify(n,i);
     }
     print("heapify");
     for(int i=n-1;i>0;i--){
        swap(0,i);
        heapify(i,0);
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
      int max = pos;
      int left = leftChild(pos);
      int right = rightChild(pos);

      if(left<n&&arr[left]>arr[max])
         max = left;

      if(right<n&&arr[right]>arr[max])
         max = right;

      if(max!=pos){
        swap(max,pos);
        heapify(s,max);
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

     Heap obj = new Heap(arr,n);
     obj.heapSort();
    
   }
}