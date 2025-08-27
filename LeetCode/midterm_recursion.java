package LeetCode;

import java.util.Arrays;

public class midterm_recursion {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int key1 = 3;
        System.out.println("Array: " + Arrays.toString(arr1) + ", key=" + key1 
                           + " → Count: " + subsetCounter(arr1, 0, key1));

        int[] arr2 = {2, 4, 6, 10};
        int key2 = 3;
        System.out.println("Array: " + Arrays.toString(arr2) + ", key=" + key2 
                           + " → Count: " + subsetCounter(arr2, 0, key2));

        int[] arr3 = {1, 1, 1, 1};
        int key3 = 3;
        System.out.println("Array: " + Arrays.toString(arr3) + ", key=" + key3 
                           + " → Count: " + subsetCounter(arr3, 0, key3));

        int[] arr4 = {3, 34, 4, 12, 5, 2};
        int key4 = 3;
        System.out.println("Array: " + Arrays.toString(arr4) + ", key=" + key4 
                           + " → Count: " + subsetCounter(arr4, 0, key4));
    }


    static int subsetCounter(int[] arr, int idx, int key) {
        if (idx>=arr.length){
            return 0;
        }

        int count=0;
        for(int i=idx; i<arr.length; i++){
            if(arr[i]==key){
                count+=1;
            }else{
                count+=subsetCounter(arr, i+1, key-arr[i]);
            }
        }
        return count;
    }
    
}
