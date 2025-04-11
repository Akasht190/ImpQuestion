class Solution {
    Integer[] memo;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        memo=new Integer[books.length];
        return minHeight(books,shelfWidth,0);
    }

    public int minHeight(int[][] books,int shelfWidth,int ind){
        if(ind>=books.length) return 0;
        int min=Integer.MAX_VALUE;
        if(memo[ind]!=null) return memo[ind];
        int height=0;
        int width=0;

        for(int i=ind;i<books.length;i++){
            width+=books[i][0];
            if(width>shelfWidth){
                break;
            }
            height=Math.max(height,books[i][1]);
            min=Math.min(min,height+minHeight(books,shelfWidth,i+1));
        }
        return memo[ind]=min;
    }
}