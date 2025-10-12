package Lab08.pack;

public class MyMergeSort_671755 {
    public void mSort(int[] arr) {
        mSort(arr,0,arr.length-1);
    }
    private void mSort(int[] arr, int low, int high) {
        if (low >= high)    return;
        int mid = low + ((high - low) >> 1);
        mSort(arr,low,mid);
        mSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private void merge(int[] arr, int low, int mid, int high) { 
        int[] tmp = new int[high - low + 1];
        int idx=0;
        int indexOfFirst=low;
        int indexOfSecond=mid+1;
        while(indexOfFirst<=mid && indexOfSecond<=high ){
            if(arr[indexOfFirst]<=arr[indexOfSecond]){
                tmp[idx]=arr[indexOfFirst];
                indexOfFirst+=1;
            }else{
                tmp[idx]=arr[indexOfSecond];
                indexOfSecond+=1;
            }
            idx+=1;
        }

        while (indexOfFirst<=mid) {
            tmp[idx]=arr[indexOfFirst];
            indexOfFirst+=1;
            idx+=1;
            
        }

        while (indexOfSecond<=high) {
            tmp[idx]=arr[indexOfSecond];
            indexOfSecond+=1;
            idx+=1;
            
        }

        for (int j=0; j<tmp.length; j++){
            arr[low+j]=tmp[j];
        }

    }
}
