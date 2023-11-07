
// time: O(n)
// space: O(n)

public class CommonAncestor {
    public static void main(String[] args) {
        int[][] parentChildPairs = new int[][]{{1,3},{2,3},{3,6},{5,6},
                {5,7},{4,5},{4,8},{8,10}};
        List<List<Integer>> list = findNodesWithZeroAndOneParent(parentChildPairs);

        boolean commonAncestor1 = commonAncestor2(parentChildPairs, 3, 8);
        boolean commonAncestor2 = commonAncestor2(parentChildPairs, 5, 8);
        boolean commonAncestor3 = commonAncestor2(parentChildPairs, 6, 8);
        boolean commonAncestor4 = commonAncestor2(parentChildPairs, 1, 3);

        System.out.println(commonAncestor1 + " " + commonAncestor2 + " " +  commonAncestor3 + " " +  commonAncestor4);
    }

    private static List<List<Integer>> findNodesWithZeroAndOneParent(int[][] pairs) {
        List<Integer> zero_ancestor = new ArrayList<>(), one_ancestor = new ArrayList<>();
        Map<Integer, Integer> numOfAncestors = new HashMap<>();
        for (int[] pair : pairs) {
            numOfAncestors.put(pair[1], numOfAncestors.getOrDefault(pair[1], 0) + 1);
            numOfAncestors.put(pair[0], numOfAncestors.getOrDefault(pair[0], 0));
        }

        for (int node : numOfAncestors.keySet()) {
            if (numOfAncestors.get(node) == 0) {
                zero_ancestor.add(node);
            }
            if (numOfAncestors.get(node) == 1) {
                one_ancestor.add(node);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zero_ancestor);
        ans.add(one_ancestor);
        return ans;
    }

    public static boolean commonAncestor2(int[][] pairs, int node1, int node2) {
        Set<Integer> pathNode1 = new HashSet<>(), pathNode2 = new HashSet<>();
        helper(pairs, node1, pathNode1);
        helper(pairs, node2, pathNode2);
        for (Integer node : pathNode1) {
            if (pathNode2.contains(node)) {
                return true;
            }
        }
        return false;
    }

    private static void helper(int[][] pairs, int node, Set<Integer> pathNode) {
        for (int[] pair : pairs) {
            if (pair[1] == node) {
                pathNode.add(pair[0]);
                helper(pairs, pair[0], pathNode);
            }
        }
        pathNode.add(node);
    }
}