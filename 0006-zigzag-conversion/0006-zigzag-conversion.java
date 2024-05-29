class Solution {
    public String convert(String s, int numRows) {
        if(numRows<=1) return s;

        StringBuilder[] ans=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            ans[i]=new StringBuilder();
        }
        boolean flag=false;
        int i=0;
        for(char ch:s.toCharArray()){
            ans[i].append(ch);
            if(i==0 || i==numRows-1) flag=!flag;
            if(flag) i++;
            else i--;
        }

        StringBuilder zigzag=new StringBuilder();
        for(StringBuilder str:ans) zigzag.append(str);
        return zigzag.toString();
    }
}