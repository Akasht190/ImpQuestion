class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long m=mass;
        Arrays.sort(asteroids);
        for(int ast:asteroids){
            if(m<ast){
                return false;
            }
            m+=ast;
        }
        return true;
    }
}