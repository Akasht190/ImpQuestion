class Solution {
    public String convertDateToBinary(String date) {
        String a[]=date.split("-");

        String result=new String("");

        result=decToBinary(Integer.parseInt(a[0]));
        result += "-" + decToBinary(Integer.parseInt(a[1]));
        result += "-" + decToBinary(Integer.parseInt(a[2]));
        return result;
    }
    private String decToBinary(int n)
    {
        String binary = new String("");
        // Size of an integer is assumed to be 32 bits
        boolean firstBit = false; // represents whether first set bit found or not
        int i = 31;
        while(i >= 0 && !firstBit){ 
            if((n >> i & 1) > 0){
                firstBit = true;
                binary += "1";
            }
            i--;
        }
        while(i >=0) {
            int bit = n >> i;
            binary += (bit & 1) > 0 ? "1" : "0";
            i--;
        }

        return binary;
    }

}