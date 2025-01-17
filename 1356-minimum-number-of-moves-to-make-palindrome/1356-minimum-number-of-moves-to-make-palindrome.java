class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] str = s.toCharArray();
        int left = 0; int right = str.length-1; int count = 0; int endindex = right;
        int centerIndex = -1;

        while (left < right) {
            if (str[left] == str[right]) {
                left++;
                right--;
                continue;
            }

            endindex = right;

            while (str[left] != str[right]) {
                right--;
            }

            if (right == left) {
                centerIndex = left;
                left++;
                right = endindex;
                continue;
            }

            while (right != endindex) {
                swap(str, right, right+1);
                right++;
                count++;
            }


            right--;
            left++;
        }

        if (centerIndex != -1) {
            System.out.println(centerIndex);
            // swaps to reach centre of the string
            count += Math.abs(centerIndex - str.length/2);
        }

        return count;
    }

    public void swap(char[] str, int left, int right) {
        char c = str[left];
        str[left] = str[right];
        str[right] = c;
        return;
    }
}