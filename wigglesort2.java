import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        
        // Step 1: Find the median using QuickSelect
        int median = findKthLargest(nums, (n + 1) / 2);

        // Step 2: Three-way partition (Dutch National Flag Algorithm)
        int left = 0, right = n - 1, i = 0;

        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
    }

    // QuickSelect to find the k-th largest element
    private int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivot = partition(nums, left, right);
            if (pivot == k - 1) return nums[pivot];
            else if (pivot < k - 1) left = pivot + 1;
            else right = pivot - 1;
        }
    }

    // Lomuto Partition for QuickSelect
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right], i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] > pivot) swap(nums, i++, j);
        }
        swap(nums, i, right);
        return i;
    }

    // Virtual Indexing (Rearrange indices for wiggle sort)
    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    // Swap helper functio
        private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
