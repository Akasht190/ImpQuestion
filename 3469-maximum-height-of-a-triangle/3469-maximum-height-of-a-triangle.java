class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(helper(red,blue),helper(blue,red));
    }

    public int helper(int red,int blue){
        int i=1;
        int h=0;

        while(true){
            if(i%2==1){
                if(red>=i){
                    red-=i;
                }else{
                    break;
                }

            }
            else{
                if(blue>=i){
                    blue-=i;
                }
                else{
                    break;
                }
            }
            i++;
            h++;
        }
        return h;
    }
}