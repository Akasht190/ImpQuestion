class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;


     //transpose a matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse a row
        for(int k=0;k<n;k++){
            int left=0;
            int right=matrix.length-1;

            while(left<right){
                int temp=matrix[k][right];
                matrix[k][right]=matrix[k][left];
                matrix[k][left]=temp;

                left++;
                right--;
            }
        }

    }
}