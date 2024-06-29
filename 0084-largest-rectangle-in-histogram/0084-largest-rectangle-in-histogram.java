class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n]; // next smaller element
        int[] pse = new int[n]; // previous smaller element
        Stack<Integer> stack = new Stack<>();

        // Compute NSE (Next Smaller Element) for each bar
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear(); // Clear stack for the next use

        // Compute PSE (Previous Smaller Element) for each bar
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxArea = 0;

        // Calculate the maximum area
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}