class Solution {
    public int numberOfChild(int n, int k) {
        n--;
        int round=k/n;
        int rem=k%n;

        if(round%2==0){
            return rem;
        }
        else{
            return (n-rem);
        }
    }
}