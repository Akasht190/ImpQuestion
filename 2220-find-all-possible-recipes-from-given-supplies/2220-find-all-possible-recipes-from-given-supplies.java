class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();

        // Map to count how many ingredients each recipe still needs (in-degree)
        Map<String, Integer> indegree = new HashMap<>();

        // Step 1: Build the graph and the in-degree map
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ingList = ingredients.get(i);

            // For each ingredient, add a connection to this recipe
            for (String ing : ingList) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }

            // Set how many ingredients this recipe needs
            indegree.put(recipe, ingList.size());
        }

        // Step 2: Add initial supplies to a queue — these are ready to use
        Queue<String> queue = new LinkedList<>();
        for (String item : supplies) {
            queue.offer(item);
        }

        // Step 3: Prepare the result list
        List<String> result = new ArrayList<>();

        // Step 4: BFS - Process ingredients/recipes that become available
        while (!queue.isEmpty()) {
            String item = queue.poll();  // Take one available ingredient or recipe

            // If this item is a dependency for any recipe...
            if (graph.containsKey(item)) {
                for (String recipe : graph.get(item)) {
                    // Reduce the number of ingredients the recipe still needs
                    indegree.put(recipe, indegree.get(recipe) - 1);

                    // If all required ingredients are now available
                    if (indegree.get(recipe) == 0) {
                        queue.offer(recipe);  // This recipe can now be made
                        result.add(recipe);   // Add to result list
                    }
                }
            }
        }

        // Step 5: Return all recipes that we were able to make
        return result;

    }
}