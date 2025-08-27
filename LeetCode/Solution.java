package LeetCode;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 1, 2, 3, 3};
        int len1 = sol.removeDuplicates(nums1);
        System.out.println("Length: " + len1 + ", Array: " + Arrays.toString(Arrays.copyOf(nums1, len1)));

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int len2 = sol.removeDuplicates(nums2);
        System.out.println("Length: " + len2 + ", Array: " + Arrays.toString(Arrays.copyOf(nums2, len2)));

        int[] nums3 = {1,1,1,1};
        int len3 = sol.removeDuplicates(nums3);
        System.out.println("Length: " + len3 + ", Array: " + Arrays.toString(Arrays.copyOf(nums3, len3)));

        int[] nums4 = {1,2,3,4,5};
        int len4 = sol.removeDuplicates(nums4);
        System.out.println("Length: " + len4 + ", Array: " + Arrays.toString(Arrays.copyOf(nums4, len4)));
    }

    public int removeDuplicates(int[] nums) {
        int end = nums.length;

        for (int i = 0; i < end - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                // shift left
                for (int j = i + 1; j < end - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                end--;   // shrink logical size
                i--;     // re-check same index
            }
        }

        return end; // number of unique elements
    }
}
