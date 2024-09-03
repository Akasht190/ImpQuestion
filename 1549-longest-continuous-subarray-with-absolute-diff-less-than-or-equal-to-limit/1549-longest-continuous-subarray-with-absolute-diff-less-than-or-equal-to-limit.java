// class Solution {
//     public int longestSubarray(int[] nums, int limit) {
//         int left=0,right=0;
//         int result=0;
//         PriorityQueue<Integer> minHeap=new PriorityQueue<>();
//         PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

//         while(right<nums.length){
//             minHeap.add(nums[right]);
//             maxHeap.add(nums[right]);

//             while(!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek()-minHeap.peek()>limit){
//                 int num=nums[left];
//                 maxHeap.remove(new Integer(num));
//                 minHeap.remove(new Integer(num));
//                 left++;
//             }

//             result=Math.max(result,right-left+1);
//             right++;
//         }
//         return result;
//     }
// }
// class Solution {

//     public int longestSubarray(int[] nums, int limit) {
//         PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
//         PriorityQueue<Integer> min = new PriorityQueue<>();

//         int i = 0, j = 0;
//         int n = nums.length;

//         max.add(nums[0]);
//         min.add(nums[0]);
//         int ans = 1;

//         while (j < n - 1) {
//             int mx = max.peek();
//             int mn = min.peek();

//             if ((mx - mn) <= limit) {
//                 ans = Math.max(ans, (j - i + 1));
//                 j++;
//                 max.add(nums[j]);
//                 min.add(nums[j]);
//             } else {
//                 max.remove(nums[i]);
//                 min.remove(nums[i]);
//                 i++;
//             }
//         }

//         if ((max.peek() - min.peek()) <= limit) ans = Math.max(ans, (j - i + 1));

//         return ans;
//     }
// }

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // Deques to keep track of the max and min values in the current window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        int left = 0;
        int result = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Maintain the max deque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            
            // Maintain the min deque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            
            // If the current window does not satisfy the condition, move the left pointer
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                // Remove elements out of the window from the deques
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }
            
            // Update the result
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}