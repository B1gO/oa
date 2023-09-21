package amazon;
import java.util.*;


class Playground {
    public static void main(String[ ] args) {
        System.out.println(solution(new int[]{-2, 0, 1}, 8L));
        System.out.println(solution(new int[]{-10, -9, 10}, 78L));
    }

    public static int solution(int[] center, long d){
        d = d / 2;
        Arrays.sort(center);
        TreeMap<Integer, Integer> centerCount = new TreeMap<>();
        long disToFirst = 0L;
        long disToLast = 0L;
        int res = 0;
        int n = center.length;
        for(int i = 0; i < n; ++i){
            int numCenterBeforeAndItself = i + 1;
            int pos = center[i];
            centerCount.put(pos, numCenterBeforeAndItself);
            disToFirst += 1L * center[i] - center[0];
            disToLast += 1L * center[n - 1] - center[i];
        }
        if(disToFirst <= d){
            res += (d - disToFirst) / n;
        }
        if(disToLast <= d){
            res += (d - disToLast) / n;
        }
        long baseDis = disToFirst;
        if(baseDis <= d){
            ++res;
        }
        for(int i = center[0] + 1; i <= center[n - 1]; ++i){  // 这里会超时
            int beforeCount = centerCount.floorEntry(i).getValue(); // increase
            int afterCount = centerCount.ceilingEntry(i).getValue(); // decrease
            if(centerCount.containsKey(i)){
                beforeCount -= 1;
            }
            baseDis += beforeCount;
            baseDis -= afterCount;
            if(baseDis <= d){
                ++res;
            }
        }
        return res;
    }
}


class Solution {
    public static void main(String[ ] args) {
        System.out.println(solution(new int[]{-2, 0, 1}, 8L));
        System.out.println(solution(new int[]{-10, -9, 10}, 78L));
        System.out.println(solution(new int[]{-3, 0, 5, 6}, 28L));
        System.out.println(solution(new int[]{1, 2}, 6L));
    }

    public static int solution2(int[] center, long d){
        d = d / 2;
        Arrays.sort(center);
        TreeMap<Integer, Integer> centerCount = new TreeMap<>();
        long disToFirst = 0L;
        long disToLast = 0L;
        int res = 0;
        int n = center.length;
        for(int i = 0; i < n; ++i){
            int numCenterBeforeAndItself = i + 1;
            int pos = center[i];
            centerCount.put(pos, numCenterBeforeAndItself);
            disToFirst += (long) center[i] - center[0];
            disToLast += (long) center[n - 1] - center[i];
        }
        if(disToFirst <= d){
            res += (d - disToFirst) / n;
        }
        if(disToLast <= d){
            res += (d - disToLast) / n;
        }
        long baseDis = disToFirst;
        if(baseDis <= d){
            res += 1;
        }
//        System.out.println("baseDis " + baseDis);
        for(int i = 1; i < n; ++i){
            int dis = center[i] - center[i - 1];
            int beforeCount = centerCount.get(center[i]) - 1;
            int afterCount = n - beforeCount;
//            System.out.println("center[i] " + center[i] + " beforeCount " + beforeCount + " afterCount " + afterCount);

            int increase = beforeCount - afterCount;
            if(increase == 0){
                if(baseDis <= d){
                    res += dis - 1;
                }
            }
            else if(increase < 0){
//                System.out.println("baseDis " + baseDis + " d " + d);
                if(baseDis >= d){
                    int countPos = (int)(baseDis - d) / -increase;
                    if((int)(baseDis - d) % -increase != 0){
                        ++countPos;
                    }
                    res += Math.max(0, dis - countPos);
                }
                else{
                    res += dis - 1;
                }
            }
            else{ // increase > 0
//                System.out.println("baseDis " + baseDis + " d " + d);
                if(baseDis < d){
                    int countPos = (int)(d - baseDis) / increase;
//                    System.out.println("countPos " + countPos);
                    res += Math.min(dis - 1, countPos);
                }
            }

            baseDis += (long) beforeCount * dis - (long) afterCount * dis;
            if(baseDis <= d){
                res += 1;
            }
//            System.out.println("baseDis " + baseDis);
//            System.out.println("res " + res);
        }
        return res;
    }

    public static int solution(int[] center, long d) {
        int n = center.length;
        long[] start = new long[n];
        long[] end = new long[n];

        for (int i = 0; i < n; i++) {
            start[i] = (long) center[i] - d;
            end[i] = (long) center[i] + d;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int activeIntervals = 0;  // to track overlapping intervals
        
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (start[i] <= end[j]) {
                activeIntervals++; 
                
                if (activeIntervals >= center.length) { // if at least 2 intervals overlap
                    count++; 
                }
                
                i++;
            } else {
                activeIntervals--;
                j++;
            }
        }

        return count;
    }
}


