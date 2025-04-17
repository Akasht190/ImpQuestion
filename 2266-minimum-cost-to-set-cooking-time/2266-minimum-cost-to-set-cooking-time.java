public class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minCost = Integer.MAX_VALUE;

        // Try all combinations of minutes and seconds
        for (int minutes = 0; minutes <= 99; minutes++) {
            for (int seconds = 0; seconds <= 99; seconds++) {
                if (minutes * 60 + seconds != targetSeconds) continue; // skip invalid ones

                // Convert to digit sequence
                String timeStr = String.format("%02d%02d", minutes, seconds); // 4-digit normalized
                String trimmed = timeStr.replaceFirst("^0+(?!$)", ""); // remove leading zeroes but not all

                int cost = calculateCost(trimmed, startAt, moveCost, pushCost);
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }

    // Helper method to calculate cost of entering the digits
    private int calculateCost(String digits, int startAt, int moveCost, int pushCost) {
        int cost = 0;
        int current = startAt;

        for (char ch : digits.toCharArray()) {
            int digit = ch - '0';
            if (current != digit) {
                cost += moveCost; // move finger to new digit
                current = digit;
            }
            cost += pushCost; // press digit
        }

        return cost;
    }
}
