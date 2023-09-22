// 这个类表示“读章节”相关的方法
public class readChapter {
    public static void main(String[] args) {
        System.out.println(getMinPages(new int[]{5, 3, 4}, 4));
        System.out.println(getMinPages(new int[]{2, 3, 4}, 4));
    }

    // 获取读完所有章节所需的最小页面数，以确保在给定的天数内完成
    public static int getMinPages(int[] pages, int days) {
        int start = 0, end = 0;
        // 找到章节中的最大页数
        for (int page : pages) {
            end = Math.max(end, page);
        }

        // 使用二分查找方法来查找最佳的阅读速度
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getPage(pages, mid) <= days) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (getPage(pages, start) <= days) {
            return start;
        }
        if (getPage(pages, end) <= days) {
            return end;
        }
        return -1;  // 如果找不到合适的阅读速度，则返回-1
    }

    // 计算给定速度下，完成所有章节所需的天数
    private static int getPage(int[] pages, double speed) {
        int days = 0;
        // 遍历每一个章节，并累计所需的天数
        for (int page : pages) {
            days += Math.ceil(page / speed);
        }
        return days;
    }
}
