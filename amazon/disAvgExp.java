import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class disAvgExp {
    public static int getDisAvgExp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length % 2 == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int cnt = 0;
        Set<Double> unique = new HashSet<>();
        while (left < right) {
            double avg = (nums[left++] + nums[right--]) / 2;
            if (unique.contains(avg)) {
                cnt++;
            } else {
                unique.add(avg);
            }
        }
        return cnt;
    }
}
