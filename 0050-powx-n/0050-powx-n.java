class Solution {
    public double myPow(double x, int n) {
        double ans=1.0;
        long ht=n;
        if(ht<0) ht=-1*ht;

       while(ht>0){
         if(ht%2==1){
            ans=ans*x;
            ht=ht-1;
         }else{
            x=x*x;
            ht=ht/2;
         }
       }

       if(n<0) ans=(double)(1.0)/(double)ans;
       return ans;
    }
}