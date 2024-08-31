class MergeSort{
    int[] arr; 
    int[] arr1;
    MergeSort(int[] arr,int size){
        this.arr = arr;
        this.arr1 = new int[size];
    }
    public void mergeSort(int low,int high){
        if(low<high){
              int mid = (low+high)/2;
              mergeSort(low,mid);
              mergeSort(mid+1,high);
              merge(low,mid,high);
        }
    }
    private void merge(int low,int mid,int high){
       int pos = low , i = low , j = mid+1;

       while(i<=mid&&j<=high){
        if(arr[i]<arr[j]){
           arr1[pos] = arr[i];
           i++;
        }
        else{
             arr1[pos] = arr[j];
             j++;
        }
        pos++;
       }

       if(i>mid){
        for(int k=j;k<=high;k++){
            arr1[pos] = arr[k];
            pos++;
        }
       }
       else{
         for(int k=i;k<=mid;k++){
            arr1[pos] = arr[k];
            pos++;
        }
       }

       for(int k=low;k<=high;k++)
          arr[k]=arr1[k];
    }
}