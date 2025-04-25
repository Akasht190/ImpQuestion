class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;

        int result=Integer.MIN_VALUE;

        for(int top=0;top<n;top++){
            int[] colo=new int[m];

            for(int bottom=top;bottom<n;bottom++){
                for(int i=0;i<m;i++){
                    colo[i]+=matrix[bottom][i];
                }

                result=Math.max(result,maxSubarray(colo,k));
            }
        }
        return result;
    }


    public int maxSubarray(int[] arr,int k){
        int n=arr.length;
        int sum=0;
        int result=Integer.MIN_VALUE;
        TreeSet<Integer> hm=new TreeSet<>();
        hm.add(0);

        for(int i=0;i<n;i++){
            sum+=arr[i];

            Integer target=hm.ceiling(sum-k);

            if(target!=null){
                result=Math.max(result,sum-target);
            }
            hm.add(sum);
        }
        return result;
    }
}