class Solution {
    public double minimumAverage(int[] nums) {
        // Arrays.sort(nums);
        // int s=0;
        // int e=nums.length-1;
        // double ans=(nums[s]+nums[e])/2.0;

        // while(s<=e){
        //    // System.out.println(ans);
        //     ans=Math.min(ans,((nums[s]+nums[e])/2.0));
        //     s++;
        //     e--;
        // }
        // return ans;

        int n=nums.length;
        double[] avgArr=new double[n/2];
        Arrays.sort(nums);

        for(int i=0;i<n/2;i++){
            double avg=(nums[i]+nums[n-1-i])/2.0;
            avgArr[i]=avg;
        }
        Arrays.sort(avgArr);
        return avgArr[0];
    }
}