import java.util.*;

public class ProcessScheduler {

    public static int[] getFinalPriorities(int[] priorities) {
        int n = priorities.length;
        List<Process> processes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            processes.add(new Process(i, priorities[i]));
        }

        while (true) {
            Map<Integer, Integer> priorityCount = new HashMap<>();
            for (Process p : processes) {
                priorityCount.put(p.priority, priorityCount.getOrDefault(p.priority, 0) + 1);
            }

            int maxSharedPriority = 0;
            for (Map.Entry<Integer, Integer> entry : priorityCount.entrySet()) {
                if (entry.getValue() >= 2 && entry.getKey() > maxSharedPriority) {
                    maxSharedPriority = entry.getKey();
                }
            }

            if (maxSharedPriority == 0) break;

            int countOfMaxPrioritySeen = 0;
            Iterator<Process> iterator = processes.iterator();
            while (iterator.hasNext()) {
                Process p = iterator.next();
                if (p.priority == maxSharedPriority) {
                    if (countOfMaxPrioritySeen == 0) { // Remove the first process
                        iterator.remove();
                    } else if (countOfMaxPrioritySeen == 1) { // Reduce the priority of the second process
                        p.priority /= 2;
                    }
                    countOfMaxPrioritySeen++;
                }
            }
        }

        int[] result = new int[processes.size()];
        for (int i = 0; i < processes.size(); i++) {
            result[i] = processes.get(i).priority;
        }
        return result;
    }

    static class Process {
        int index;
        int priority;

        Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }


    public static void main(String[] args) {
        // int[] priorities = {6, 6, 6, 1, 2, 2};
        // int[] priorities = {5, 3, 5, 4, 2};
        int[] priorities =  {6, 6, 1, 2, 2};
        int[] result = getFinalPriorities(priorities);
        System.out.println(Arrays.toString(result));  // Output: [3, 6, 0]
    }
}

