class Solution {
    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        int n = arr.length;

        // Step 1: Count zeroes that can be duplicated
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) zeros++;
        }

        // Step 2: Work backwards and shift elements
        for (int i = n - 1; i >= 0; i--) {
            if (i + zeros < n) {
                arr[i + zeros] = arr[i]; // Shift
            }

            if (arr[i] == 0) {
                zeros--;
                if (i + zeros < n) {
                    arr[i + zeros] = 0; // Duplicate zero
                }
            }
        }
    }
}