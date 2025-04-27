class Solution {
    public int countCoveredBuildings(int n, int[][] grid) {
        Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();

        // Fill the maps
        for (int[] p : grid) {
            int x = p[0], y = p[1];

            rowMap.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            colMap.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }

        int count = 0;

        for (int[] p : grid) {
            int x = p[0], y = p[1];

            TreeSet<Integer> rowSet = rowMap.get(x);
            TreeSet<Integer> colSet = colMap.get(y);

            boolean left  = rowSet.lower(y) != null;   // element before y
            boolean right = rowSet.higher(y) != null;  // element after y
            boolean up    = colSet.lower(x) != null;   // element before x
            boolean down  = colSet.higher(x) != null;  // element after x

            if (left && right && up && down) {
                count++;
            }
        }

        return count;
    }
}