class Solution {
    public int findNumbers(int[] nums) {
        int dig=0;
        int count=0;
        int evno=0;
        for(int n: nums)
        {
            while(n!=0)
            {
                dig=n%10;
                count++;
                n=n/10;   
            }
            if(count%2==0)
            {
                evno++;
            }
            count=0;
        }
        return evno;
    }
}