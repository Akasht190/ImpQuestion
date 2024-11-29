class Solution {
    public long countGood(int[] nums, int k) {
        //TC-o(N^4) SC-O(1)
        // long count=0;

        // for(int i=0;i<nums.length;i++){
        //     for(int j=i;j<nums.length;j++){
        //           int pariCount=0;


        //           for(int m=i;m<j;m++){
        //             for(int n=m+1;n<=j;n++){
        //                 if(nums[m]==nums[n]){
        //                     pariCount++;
        //                 }
        //             }
        //           }

        //           if(pariCount>=k){
        //               count++;
        //           }
        //     }
        // }
        // return count;

        //TC-o(n^2) sc-o(n);
        // long count=0;
        // for(int i=0;i<nums.length;i++){
        //     HashMap<Integer,Integer> hm=new HashMap<>();
        //     int pariCount=0;

        //     for(int j=i;j<nums.length;j++){
        //         int num=nums[j];
        //         int c=hm.getOrDefault(num,0);

        //         pariCount+=c;
        //         hm.put(num,c+1);

        //         if(pariCount>=k){
        //             count++;
        //         }
        //     }
        // }
        // return count;
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i=0;
        int j=0;
        long count=0;
        long ans=0;
        while(j<nums.length){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            count+=hm.get(nums[j])-1;

            while(count>=k){
                ans+=nums.length-j;
                count-=hm.get(nums[i])-1;
                hm.put(nums[i],hm.getOrDefault(nums[i],0)-1);

                if(hm.get(nums[i])==0){
                    hm.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
       return ans;
    }
}