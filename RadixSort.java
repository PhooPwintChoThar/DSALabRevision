import java.util.*;

public class RadixSort {
    
  
    public static void radixSort(int[] arr) {
            int max=Integer.MIN_VALUE;
            for(int n: arr){
                if (n>max) max=n;
            }

            int digits=Integer.toString(max).length();

            int curr_d=1;


            while((max/curr_d)>0){
                List<Queue<Integer>> containers= new ArrayList<>();
                for(int i=0 ; i<10; i++){
                    containers.add(new LinkedList<>());
                }

                for(int n: arr){
                    int d= (n/curr_d)%10;
                    containers.get(d).offer(n);
                }
                int k=0;
                for(int i=0; i<10; i++){
                    Queue<Integer> curr_con=containers.get(i);
                    while(!curr_con.isEmpty()){
                        arr[k]=curr_con.poll();
                        k+=1;
                    }
                }

                curr_d*=10;


            }
    }
    
    // Test your implementation
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Test 1:");
        System.out.println("Before: " + Arrays.toString(arr1));
        radixSort(arr1);
        System.out.println("After:  " + Arrays.toString(arr1));
        System.out.println("Expected: [2, 24, 45, 66, 75, 90, 170, 802]");
        System.out.println();
        
        // Test case 2
        int[] arr2 = {329, 457, 657, 839, 436, 720, 355};
        System.out.println("Test 2:");
        System.out.println("Before: " + Arrays.toString(arr2));
        radixSort(arr2);
        System.out.println("After:  " + Arrays.toString(arr2));
        System.out.println("Expected: [329, 355, 436, 457, 657, 720, 839]");
        System.out.println();
        
        // Test case 3 - Already sorted
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Test 3:");
        System.out.println("Before: " + Arrays.toString(arr3));
        radixSort(arr3);
        System.out.println("After:  " + Arrays.toString(arr3));
        System.out.println("Expected: [1, 2, 3, 4, 5]");
        System.out.println();
        
        // Test case 4 - Reverse sorted
        int[] arr4 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Test 4:");
        System.out.println("Before: " + Arrays.toString(arr4));
        radixSort(arr4);
        System.out.println("After:  " + Arrays.toString(arr4));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }
}

