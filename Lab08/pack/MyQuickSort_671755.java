package Lab08.pack;

public class MyQuickSort_671755 {
    public void qSort(int[] arr) {
        qSort_lumoto(arr, 0, arr.length-1);
    }
    private void qSort_lumoto(int[] arr, int low, int high) {
        if (low < high) {
            int pivot_index = partition_lomuto(arr, low, high);
            qSort_lumoto(arr, low, pivot_index - 1);
            qSort_lumoto(arr, pivot_index + 1, high);
        }
    } 
    private int partition_lomuto(int[] arr, int low, int high) { 
        int pivot_v = arr[high];
        int i = low, tmp;
        
        int j=high-1;
        while (true) {
      
        while (i <= j && arr[i] < pivot_v) {
            i++;
        }


        while (j >= i && arr[j] > pivot_v) {
            j--;
        }


        if (i >= j) break;

        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

       
        i++;
        j--;
    }

    tmp = arr[i];
    arr[i] = arr[high];
    arr[high] = tmp;

        return i;
    }
}