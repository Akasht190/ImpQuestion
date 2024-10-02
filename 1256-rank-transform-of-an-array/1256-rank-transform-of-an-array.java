class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return arr;

        int sorted[] = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        map.put(sorted[0], rank++);
        for (int i = 1; i < arr.length; i++) {
            if(sorted[i] == sorted[i - 1]) continue;
            else map.put(sorted[i], rank++); 
        }

        for (int i = 0; i < arr.length; i++) {
            sorted[i] = map.get(arr[i]);
        }

        return sorted;

    }
}