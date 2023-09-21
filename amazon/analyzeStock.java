import java.util.ArrayDeque;
import java.util.Deque;

public class analyzeStock {
    public static long countMaximumProfitableGroups(int[] stockPrice) {
        int len = stockPrice.length;
        long cnt = 0L;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int right = 0; right < len; right++) {
            while (!stack.isEmpty() && stockPrice[stack.peek()] <= stockPrice[right]) {
                stack.pop();
            }
            cnt += (right - (stack.isEmpty() ? -1 : stack.peek()));
            stack.push(right);
        }

        stack.clear();

        for (int right = len - 1; right >= 0; right--) {
            long width = 0;
            while (!stack.isEmpty() && stockPrice[stack.peek()] < stockPrice[right]) {
                stack.pop();
            }
            cnt += (stack.isEmpty() ? len : stack.peek()) - right - 1;
            stack.push(right);
        }
        return cnt;
    }
}