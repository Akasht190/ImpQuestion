import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger sum = x.add(y);
        String result = sum.toString(2);
        return result;
    }
}