class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans=new ArrayList<>();
        if(finalSum%2!=0){
            return ans;
        }

        long currNum=2;
        long remainSum=finalSum;

        while(currNum<=remainSum){
            ans.add(currNum);
            remainSum-=currNum;
            currNum+=2;
        }

        long last=ans.remove(ans.size()-1);
        ans.add(last+remainSum);
        return ans;
    }
}