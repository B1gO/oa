
public class FindSpareTime {
    public static void main(String[] args) {
        int[][] meetings = new int[][]{
                {1300, 1500}, {930, 1200}, {830, 845}, {840, 920}
        };
        List<int[]> res1 = findSpareTime(meetings);
        List<int[]> res2 = findSpareTime(meetings);
        for (int[] res : res1) {
            System.out.println(res[0] + " " + res[1]);
        }
    }

    public static List<int[]> findSpareTime(int[][] intervals) {
        int[][] mergeIntervals = merge(intervals);
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{0, mergeIntervals[0][0]});
        for (int i = 1; i < mergeIntervals.length; i++) {
            res.add(new int[]{mergeIntervals[i - 1][1], mergeIntervals[i][0]});
        }
        return res;
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
