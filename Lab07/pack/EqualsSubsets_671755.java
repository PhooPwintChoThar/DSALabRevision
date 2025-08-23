package Lab07.pack;

public class EqualsSubsets_671755 {

     public  boolean canPartition_Recurse(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) return false;
        
        int target = totalSum / 2;
        return canPartitionRecursive(arr, 0, target);
    }
    
    private  boolean canPartitionRecursive(int[] arr, int index, int target) {
       
        if (target == 0) return true;
        if (index >= arr.length || target < 0) return false;
        
    
        return canPartitionRecursive(arr, index + 1, target - arr[index]) ||
               canPartitionRecursive(arr, index + 1, target);
    }

     public  boolean canPartition_Memoiz(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) return false;
        
        int target = totalSum / 2;
        int[][] memo = new int[arr.length][target + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                memo[i][j] = -1;
            }
        }
        return canPartitionMemoized(arr, 0, target, memo) == 1;
    }
    
    private  int canPartitionMemoized(int[] arr, int index, int target, int[][] memo) {
        if (target == 0) return 1; 
        if (index >= arr.length || target < 0) return 0; 
        
        if (memo[index][target] != -1) {
            return memo[index][target];
        }
        
   
        memo[index][target] = (canPartitionMemoized(arr, index + 1, target - arr[index], memo) == 1 ||
                              canPartitionMemoized(arr, index + 1, target, memo) == 1) ? 1 : 0;
        return memo[index][target];
    }
    
    public  boolean canPartition_DP(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) return false;
        
        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true; 
        for (int num : arr) {
   
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[target];
    }

}
