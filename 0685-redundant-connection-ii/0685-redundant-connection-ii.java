class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] root = new int[n + 1];
        int[] edge1 = null;
        int[] edge2 = null;

        // Step 1: Check for a node with two parents
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] != 0) {
                edge1 = new int[]{parent[v], v}; // first edge
                edge2 = new int[]{u, v};         // second edge
                edge[1] = 0; // Temporarily invalidate the second edge
            } else {
                parent[v] = u;
            }
        }

        // Step 2: Union-Find to detect cycles
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (v == 0) continue; // skip invalidated edge

            int parentU = find(root, u);
            int parentV = find(root, v);
            if (parentU == parentV) {
                if (edge1 != null) return edge1; // has two parents and a cycle
                return edge; // only a cycle
            }
            root[parentV] = parentU; // union
        }

        return edge2; // has two parents but no cycle
    }

    private int find(int[] root, int u) {
        if (root[u] != u) {
            root[u] = find(root, root[u]);
        }
        return root[u];
    }
}
