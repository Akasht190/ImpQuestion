class NumMatrix {
    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int n = matrix.length;
        int m = matrix[0].length;
        prefixSum = new int[n][m];

        // Initialize prefixSum array
        prefixSum[0][0] = matrix[0][0];

        // Fill first row
        for (int j = 1; j < m; j++) {
            prefixSum[0][j] = prefixSum[0][j - 1] + matrix[0][j];
        }

        // Fill first column
        for (int i = 1; i < n; i++) {
            prefixSum[i][0] = prefixSum[i - 1][0] + matrix[i][0];
        }

        // Fill rest of the prefixSum array
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefixSum[i][j] = matrix[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (prefixSum == null) return 0;

        int total = prefixSum[row2][col2];
        int extraAbove = row1 > 0 ? prefixSum[row1 - 1][col2] : 0;
        int extraLeft = col1 > 0 ? prefixSum[row2][col1 - 1] : 0;
        int extraOverlap = (row1 > 0 && col1 > 0) ? prefixSum[row1 - 1][col1 - 1] : 0;
        
        return total - extraAbove - extraLeft + extraOverlap;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */