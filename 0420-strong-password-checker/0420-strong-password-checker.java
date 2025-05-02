class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;

        char[] chars = password.toCharArray();

        // Count types and prepare to check repeats
        int replacements = 0;
        int oneMod = 0;   // count of sequences with len % 3 == 0
        int twoMod = 0;   // count of sequences with len % 3 == 1
        int i = 0;

        while (i < n) {
            char c = chars[i];

            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;

            int len = 1;
            while (i + len < n && chars[i + len] == c) {
                len++;
            }

            if (len >= 3) {
                replacements += len / 3;
                if (len % 3 == 0) oneMod++;
                else if (len % 3 == 1) twoMod++;
            }

            i += len;
        }

        int missingTypes = 0;
        if (!hasLower) missingTypes++;
        if (!hasUpper) missingTypes++;
        if (!hasDigit)  missingTypes++;

        if (n < 6) {
            return Math.max(missingTypes, 6 - n);
        } else if (n <= 20) {
            return Math.max(missingTypes, replacements);
        } else {
            int deletions = n - 20;
            int remainingDeletions = deletions;

            // Optimize deletions to reduce replacements
            if (remainingDeletions > 0) {
                int reduce = Math.min(oneMod, remainingDeletions);
                replacements -= reduce;
                remainingDeletions -= reduce;

                reduce = Math.min(twoMod * 2, remainingDeletions);
                replacements -= reduce / 2;
                remainingDeletions -= reduce;

                reduce = Math.min(replacements * 3, remainingDeletions);
                replacements -= reduce / 3;
                remainingDeletions -= reduce;
            }
         return deletions + Math.max(missingTypes, replacements);
    }
    }
}
