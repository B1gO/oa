

import java.util.*;

public class gameAnalysis {
    public static void main(String[] args) {
        int[][] averageStanding = getAverageStanding(3, new int[][]{{1, 1, 100}, {1, 2, 200}, {2, 1, 500}});
        Arrays.stream(averageStanding).forEach(n -> {
            Arrays.stream(n).forEach(i -> System.out.print(i + " " ));
            System.out.println();
        });
    }

    public static int[][] getAverageStanding(int d, int[][] records) {
        // Create a map to store standings for each player
        Map<Integer, List<Integer>> playerStandings = new HashMap<>();

        // Initialize the 2D array to store average standings for each player
        int[][] avgStandings = new int[d][2];
        for (int i = 0; i < d; i++) {
            avgStandings[i][0] = -1;
            avgStandings[i][1] = -1;
        }

        // Sort records by race ID, time, and player ID
        Arrays.sort(records, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[1], b[1]);
        });

        // Calculate standings for each player in each race
        int raceId = -1;
        int standing = 0;
        for (int i = 0; i < records.length; i++) {
            int currRaceId = records[i][0];
            int playerId = records[i][1];

            if (currRaceId != raceId) {
                raceId = currRaceId;
                standing = 1;
            } else {
                standing++;
            }

            // Update standings in the map
            playerStandings.putIfAbsent(playerId, new ArrayList<>());
            playerStandings.get(playerId).add(standing);
        }

        // Calculate the average standing for each player
        for (Map.Entry<Integer, List<Integer>> entry : playerStandings.entrySet()) {
            int playerId = entry.getKey();
            List<Integer> standings = entry.getValue();

            int sum = 0;
            for (int standingValue : standings) {
                sum += standingValue;
            }

            int numerator = sum;
            int denominator = standings.size();
            if (numerator % denominator == 0) {
                numerator = numerator / denominator;
                denominator = 1;
            }

            avgStandings[playerId][0] = numerator;
            avgStandings[playerId][1] = denominator;
        }
        return avgStandings;
    }
}
