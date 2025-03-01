class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Step 1: Check if mid is the target
            if (nums[mid] == target) return mid;
            
            // Step 2: Determine which half is sorted
            if (nums[low] <= nums[mid]) { // Left half is sorted
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Search in the left half
                } else {
                    low = mid + 1; // Search in the right half
                }
            } else { // Right half is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // Search in the right half
                } else {
                    high = mid - 1; // Search in the left half
                }
            }
        }
        
        return -1; // Target not found
    }
}
