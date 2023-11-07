package walmart;

import java.util.*;

public class traversePages2 {
    public static void main(String[] args) {
        int[][] choices1 = {{3, 7, 9}, {9, 11}};
        int[] goodEndings = {12, 15};
        int[] badEndings = {5, 6, 10};
        List<Integer> reachableGoodEndings = traverseBook(choices1, goodEndings, badEndings);
        for (Integer i : reachableGoodEndings) {
            System.out.println("Reachable Good Endings: " + i);
        }
    }

    public static List<Integer> traverseBook(int[][] choices, int[] goodEndings, int[] badEndings) {
        Map<Integer, int[]> jump = new HashMap<>();
        for (int[] choice : choices) {
            int[] next = Arrays.copyOfRange(choice, 1, choice.length);
            jump.put(choice[0], next);
        }

        Set<Integer> badSet = new HashSet<>();
        for (int badEnding : badEndings) {
            badSet.add(badEnding);
        }

        Set<Integer> goodSet = new HashSet<>();
        for (int goodEnding : goodEndings) {
            goodSet.add(goodEnding);
        }

        int maxGood = Arrays.stream(goodEndings).max().orElse(0);
        Set<Integer> visited = new HashSet<>();

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int n = q.poll();
            if (visited.contains(n)) {
                continue;
            }

            visited.add(n);

            if (badSet.contains(n)) {
                continue;
            }

            if (goodSet.contains(n)) {
                ans.add(n);
            }
            int[] nextPages = jump.getOrDefault(n, new int[0]);
            for (int nextPage : nextPages) {
                q.offer(nextPage);
            }

            if (n + 1 <= maxGood) {
                q.offer(n + 1);
            }
        }

        return ans;
    }
}