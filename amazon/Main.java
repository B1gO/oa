import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        int[] nums1 = {3, 9, 4, 2, 16};
//        int[] nums2 = {1, 2, 3, 4, 1, 1};
//        int[] nums3 = {1, 2, 3};
//        System.out.println(maxLengthOfPerfectSet.maxSetSize(nums1));
//        System.out.println(maxLengthOfPerfectSet.maxSetSize(nums2));
//        System.out.println(maxLengthOfPerfectSet.maxSetSize(nums3));

//        int[] nums = {1, 4, 1, 3, 5, 6};
//        System.out.println(disAvgExp.getDisAvgExp(nums));

//        int[] nums1 = {1, 2, 3};
//        int days1 = 3;
//
//        int[] nums2 = {1, 2, 3};
//        int days2 = 4;
//
//        int[] nums3 = {1, 2, 3, 10, 20, 30, 40};
//        int days3 = 9;
//
//        System.out.println(readChapter.getMinPages(nums3, days3));

//        int[] skill = {3, 4, 3, 1, 6, 5};
//        System.out.println(maxTeamHackathon.getMaxTeams(skill, 3, 2));

//        int[] comedyReleaseTime = {1, 4};
//        int[] comedyDuration = {3, 2};
//        int[] dramaReleaseTime = {5, 2};
//        int[] dramaDuration = {2, 2};
//
//        int earliestTime = primeMovie.minimumTimeSpent(comedyReleaseTime, comedyDuration, dramaReleaseTime, dramaDuration);
//        System.out.println(earliestTime);

//        int n = 3;
//        int d = 3;
//        int[][] records = { {1, 1, 100}, {1, 2, 200}, {2, 1, 500} };
//        int[][] avgStandings = gameAnalysis.getAverageStanding(d, records);

//        int n = 5;
//        int d = 5;
//        int[][] records = { {25, 1, 1000}, {25, 2, 2000}, {25, 4, 200}, {30, 2, 90}, {30, 1, 90}, {30, 4, 90}, {35, 1, 50000} };
//        int[][] avgStandings = gameAnalysis.getAverageStanding(d, records);
//
//        for (int i = 0; i < d; i++) {
//            System.out.println(Arrays.toString(avgStandings[i]));
//        }

        int[] stockPrice = {1, 5, 2};
        long res = analyzeStock.countMaximumProfitableGroups(stockPrice);
        System.out.println(res);
    }
}