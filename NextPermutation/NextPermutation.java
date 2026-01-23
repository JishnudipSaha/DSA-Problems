package NextPermutation;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // 1. Find the pivot
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 2. If pivot exists, find rightmost successor
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 3. Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        // Test Case 1
        int[] nums1 = {1, 2, 3};
        nextPermutation.nextPermutation(nums1);
        System.out.println("Next Permutation: " + Arrays.toString(nums1));

        // Test Case 2
        int[] nums2 = {3, 2, 1};
        nextPermutation.nextPermutation(nums2);
        System.out.println("Next Permutation: " + Arrays.toString(nums2));

        // Test Case 3
        int[] nums3 = {1, 1, 5};
        nextPermutation.nextPermutation(nums3);
        System.out.println("Next Permutation: " + Arrays.toString(nums3));
    }
}
