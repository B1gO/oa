import java.util.*;

public class ProcessScheduler {

    public static int[] getFinalPriorities(int[] priorities) {
        int n = priorities.length;
        List<Process> processes = new ArrayList<>();

        // 初始化：将所有进程按顺序添加到列表中
        for (int i = 0; i < n; i++) {
            processes.add(new Process(i, priorities[i]));
        }

        // 循环直到算法终止条件满足
        while (true) {
            Map<Integer, Integer> priorityCount = new HashMap<>();
            // 统计每个优先级的进程数量
            for (Process p : processes) {
                priorityCount.put(p.priority, priorityCount.getOrDefault(p.priority, 0) + 1);
            }

            int maxSharedPriority = 0;
            // 找出至少有两个进程共享的最大优先级
            for (Map.Entry<Integer, Integer> entry : priorityCount.entrySet()) {
                if (entry.getValue() >= 2 && entry.getKey() > maxSharedPriority) {
                    maxSharedPriority = entry.getKey();
                }
            }

            // 如果没有这样的优先级，终止算法
            if (maxSharedPriority == 0) break;

            int countOfMaxPrioritySeen = 0;
            Iterator<Process> iterator = processes.iterator();
            while (iterator.hasNext()) {
                Process p = iterator.next();
                if (p.priority == maxSharedPriority) {
                    if (countOfMaxPrioritySeen == 0) { // 删除第一个进程
                        iterator.remove();
                    } else if (countOfMaxPrioritySeen == 1) { // 减少第二个进程的优先级
                        p.priority /= 2;
                    }
                    countOfMaxPrioritySeen++;
                }
            }
        }

        int[] result = new int[processes.size()];
        // 提取剩余进程的优先级
        for (int i = 0; i < processes.size(); i++) {
            result[i] = processes.get(i).priority;
        }
        return result;
    }

    // 定义进程类，包括索引和优先级
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
/**
 * 
 * Several processes are scheduled for execution on an AWS server
On one server, n processes are scheduled where the th process is assigneda priority of priorityli. The processes are placed sequentially in a queue andare numbered 1, 2, .., n. The server schedules the processes per thefollowing algorithm:
1. It finds the maximum priority shared by at least 2 processes. Let that bedenoted by p.
1. If there is no such priority or p = 0, the algorithm is terminated.2. Otherwise, select the two of the processes with the lowest indexesand priority p, call them process1 and process2.
3. The server executes process1 and removes it from the queue.
4. To avoid starvation, it reduces the priority of process2 to floorp/2).
5. Start again from step 1.
Given the initial priority of the processes, find the final priority of theprocesses which remain after the algorithm terminates.
Note that relative the arrangement of remaining processes in the queueremains the same, only their priorities change.
 */

