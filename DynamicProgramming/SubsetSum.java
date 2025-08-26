package DynamicProgramming;

import java.util.Arrays;

//Given an array arr[] of size n and a target sum S, determine if there exists a subset that sums to S.
public class SubsetSum {

    public static void main(String[] args){
        boolean a=SubsetExists(new int[]{5}, 8);
        boolean b=SubsetExists(new int[]{2,3,7,8}, 10);
        System.out.println(b);
        System.out.println(a);

    }
    
    static boolean SubsetExists(int[] arr, int target){

        if (arr.length==0){
            return false;
        }
        int sum=0;

        for (int i=0 ; i<arr.length; i++){
            sum+=arr[i];
            if(sum==target){
                return true;
            }
        }
        
        return SubsetExists(Arrays.copyOfRange(arr, 1, arr.length), target);
    }
}
