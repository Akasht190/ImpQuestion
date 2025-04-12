class Solution {
    public int minimumPairRemoval(int[] nums) {
        
        List<Integer> l = new ArrayList<>();
        
        for(int num:nums) l.add(num);
        
        int count = 0;
        
        while(!solve(l)){
            int minSum = Integer.MAX_VALUE;
            
            int index = 0;
            
            for(int i = 0 ;i<l.size()-1;i++){
                int sum = l.get(i) + l.get(i+1);
                
                if(minSum>sum){
                    minSum = sum;
                    index = i;
                }
            }
            
            int merg = l.get(index) + l.get(index+1);
            
            l.remove(index+1);
            
            
            l.set(index,merg);
            count++;
        }
        
        return count;
    }
    public boolean solve(List<Integer> l){
        
        for(int i = 0;i<l.size()-1;i++){
            if(l.get(i)>l.get(i+1)) return false;
        }
        
        return true;
    }
}