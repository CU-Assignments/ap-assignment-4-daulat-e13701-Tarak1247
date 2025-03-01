import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int[] row : matrix) {
            for (int num : row) {
                minHeap.add(num);
            }
        }

        // Extract k-th smallest element
        while (--k > 0) {
            minHeap.poll();
        }
        
        return minHeap.poll();
    }
}
