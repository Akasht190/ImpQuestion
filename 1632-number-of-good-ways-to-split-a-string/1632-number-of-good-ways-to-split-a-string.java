import java.util.*;

class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int count = 0;

        // Arrays to store the count of unique characters in prefix and suffix
        int[] prefixUnique = new int[n];
        int[] suffixUnique = new int[n];

        // To track character frequencies
        Map<Character, Integer> prefixFreq = new HashMap<>();
        Map<Character, Integer> suffixFreq = new HashMap<>();

        // Fill prefix unique count
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            prefixFreq.put(c, prefixFreq.getOrDefault(c, 0) + 1);
            prefixUnique[i] = prefixFreq.size();  // Store unique count for prefix up to index i
        }

        // Fill suffix unique count
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            suffixFreq.put(c, suffixFreq.getOrDefault(c, 0) + 1);
            suffixUnique[i] = suffixFreq.size();  // Store unique count for suffix starting at index i
        }

        // Count valid splits
        for (int i = 0; i < n - 1; i++) {  // We don’t need to consider the last index as a split point
            if (prefixUnique[i] == suffixUnique[i + 1]) {
                count++;
            }
        }

        return count;
    }
}
